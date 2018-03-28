window.onload = function(){ //1 
	loadLanding();
}
function loadLanding(){ //1 
	var xhr = new XMLHttpRequest();
	xhr.open("GET", "loadlanding.view" , true);
	xhr.send();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			$('#view').html(xhr.responseText);
			$('#login').on('click', login); 
			$('#pass').keydown(function(event){
				var keypressed = event.keyCode || event.which;
				if(keypressed == 13)  login();
			});
		}
	}
}
function login(){
	console.log("logging in");
	$('#message').hide();
	var username = $('#username').val();
	var password = $('#pass').val();
	var toSend = [username, password];
	var xhr = new XMLHttpRequest();
	xhr.open("POST", "login", true);
	xhr.send(JSON.stringify(toSend));
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			var employee = JSON.parse(xhr.responseText);
			var message = "";
			if(employee==null) {
				$('#message').show();
				$("#message").attr("style", "display:inline");
				message = "You have entered the wrong username and/or password. Please try again";
				$('#message').html(message);
			}
			else{
				loadNav(employee);
				loadHome(employee);
			}
		}
	}
}
function logout(){
	console.log("logging out");
	var xhr = new XMLHttpRequest();
	xhr.open("GET", "logout" , true);
	xhr.send();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			console.log("attempting to redirect");
			window.location.replace("index.html");
		}
	}
}
function loadNav(employee){
	var xhr = new XMLHttpRequest();
	xhr.open("GET", "loadnav.view" , true);
	xhr.send();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			$('#navbar').html(xhr.responseText);
			$('#mybrand').on('click', loadHome);
			$('#home').on('click', loadHome);
			$('#logout').on('click',logout);
			$('#events').on('click', loadEmployeeEvents);
			if(employee.rank>1){
			$('#approvals').on('click', loadApprovals);
			}
			console.log(employee.rank);
			}
			
		}
	
}
function loadEmployeeReimbursements(){
	var xhr = new XMLHttpRequest();
	xhr.open("GET", "loadEmployeeReimbursements.view", true);
	xhr.send();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			$('#view').html(xhr.responseText);
			getEmployeeReimbursements();
		}
	}
}
function getEmployeeReimbursements(){
	var xhr = new XMLHttpRequest();
	xhr.open("GET", "reimbursements" , true);
	xhr.send();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			var reimbursements = JSON.parse(xhr.responseText);
			if(reimbursements.length == 0){
				console.log("you have no reimbursements");
				$('#view').html("You have no reimbursements")
			}
			else{
				console.log("testing----");
				console.log(reimbursements);
				var data = formatEmpReTable(reimbursements);
				$('#reimbursementTable').DataTable({
					data : data,
					columns: [
						{data : "userid" },
						{data : "type" },
						{data : "gradingFormat" },
						{data : "dateCreated"},
						{data : "dateScheduled"},
						{data : "eventLocation" },
						{data : "descpition" },
						{data : "eventCost" },
						{data : "why" },
						{data : "timeofday" },
						{data : "t1" },
						{data : "t2" },
						{data : "t3" },
						{data : "tfinal" }
						]
				});
				console.log("this should have worked");
				$('#reimbursementTable').show();
			}
		}
	}
}
function formatEmpReTable(reimbursements){
	console.log("formatting table");
	var data = [];
	for(let i = 0; i < reimbursements.length; i++){
		let temp = new Object();
		console.log(reimbursements[i]);
		console.log(reimbursements[i]);
		temp.userid = events[i].userid;
		temp.type = events[i].type;
		temp.gradingFormat = events[i].gradingFormat;
		temp.dateCreated = events[i].startD;
		temp.dateScheduled = events[i].endD;
		temp.eventLocation = events[i].loaction;
		temp.descpition = events[i].descpition;
		temp.eventCost = events[i].cost;
		temp.why = events[i].why;
		temp.timeofday = events[i].timeofday;
		temp.t1 = events[i].t1;
		temp.t2 = events[i].t2;
		temp.t3 = events[i].t3;
		temp.tfinal = events[i].tfinal;
		console.log(temp);
		data.push(temp);
	}
	console.log(data);
	return data;
}
function loadApprovals(){
	var xhr = new XMLHttpRequest();
	xhr.open("GET", "loadApprovals.view", true);
	xhr.send();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			$('#view').html(xhr.responseText);
			getPendingReimbursements();
		}
	}
}
function getPendingReimbursements(){
	var xhr = new XMLHttpRequest();
	xhr.open("GET", "apprReimbursements" , true);
	xhr.send();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			var reimbursements = JSON.parse(xhr.responseText);
			if(reimbursements.length == 0){
				console.log("you have no events");
				$('#view').html("No reimbursements awaiting approval");
			}
			else{
				console.log("testing----");
				console.log(reimbursements);
				var data = formatReTable(reimbursements);
				$('#reimbursementAppTable').DataTable({
					data : data,
					columns: [
						{data : "userid" },
						{data : "type" },
						{data : "gradingFormat" },
						{data : "dateCreated"},
						{data : "dateScheduled"},
						{data : "eventLocation" },
						{data : "descpition" },
						{data : "eventCost" },
						{data : "why" },
						{data : "timeofday" },
						{data : "t1" },
						{data : "t2" },
						{data : "t3" },
						{data : "tfinal" }
						]
				});
				console.log("this should have worked");
				$('#reimbursementAppTable').show();
			}
		}
	}
}
function formatReTable(reimbursements){
	console.log("formatting table");
	var data = [];
	for(let i = 0; i < reimbursements.length; i++){
		let temp = new Object();
		console.log(reimbursements[i]);
		temp.userid = reimbursements[i].userid;
		temp.type = reimbursements[i].type;
		temp.gradingFormat = reimbursements[i].gradingFormat;
		temp.dateCreated = reimbursements[i].startD;
		temp.dateScheduled = reimbursements[i].endD;
		temp.eventLocation = reimbursements[i].loaction;
		temp.descpition = reimbursements[i].descpition;
		temp.eventCost = reimbursements[i].cost;
		temp.why = reimbursements[i].why;
		temp.timeofday = reimbursements[i].timeofday;
		temp.t1 = reimbursements[i].t1;
		temp.t2 = reimbursements[i].t2;
		temp.t3 = reimbursements[i].t3;
		temp.tfinal = reimbursements[i].tfinal;
		console.log(temp);
		data.push(temp);
	}
	console.log(data);
	return data;
}
function loadHome(employee){
	var xhr = new XMLHttpRequest();
	xhr.open("GET", "loadhome.view" , true);
	xhr.send();
	var coverage = 1;
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			$('#view').html(xhr.responseText);
			$('#firstname').val(employee.firstname);
			$('#lastname').val(employee.lastname);
			$('#cost').keypress(function(e){
				if(e.which != 8 && e.which !=0 && (e.which < 48 || e.which > 57)){
					return false;
				}
			});
			$('#cost').keyup(function(){
				console.log("keyup");
				switch($('#event-type').val()){
					case "1" : coverage = 0.8;break;
					case "2" : coverage = 0.6;break;
					case "3" : coverage = 0.75;break;
					case "4" : coverage = 1;break;
					case "5" : coverage = 0.9;break;
					case "6" : coverage = 0.3;
				}
				console.log(coverage);
				$('#requested-amount').val((parseInt($('#cost').val())*coverage).toFixed(2));
			});
			$('#event-type').on('change',function(){
				console.log("keyup");
				switch($('#event-type').val()){
					case "1" : coverage = 0.8;break;
					case "2" : coverage = 0.6;break;
					case "3" : coverage = 0.75;break;
					case "4" : coverage = 1;break;
					case "5" : coverage = 0.9;break;
					case "6" : coverage = 0.3;
				}
				console.log(coverage);
				$('#requested-amount').val((parseInt($('#cost').val())*coverage).toFixed(2));
			});
			$('#submitReimbursement').click(function(){submitReimbursement(employee)});
		}
	}
}
function toTimeStamp(strDate){
	var datum = Date.parse(strDate);
	return datum/1000;
}
function submitReimbursement(employee){
	console.log("submit");
	var superApp = -1;
	var depHeadApp = -1;
	var BCApp = -1;
	var finalApp= -1;
	var gradingF= $('#GradingF').val();
	var sdate = $('#Sdate').val();
	var edate = $('#Edate').val();
	var location= $('#location').val();
	var description = $('#description').val();
	var cost = $('#cost').val();
	var eventTypeId = $('#event-type').val();
	var justification = $('#justification').val();
	var why = $('#why').val();
	var timeofday = $('#timeofday').val();
	
	if($('#check1').is(":checked")){
		superApp = 1;
	}
	if($('#check2').is(":checked")){
		depHeadApp = 1;
	}
	var requestedAmount = $('#requested-amount').val();
	var eventForm = {
			
			startD: sdate, 
			endD: edate,
			loaction:location,
			cost: cost,
			descpition: description,
			type: eventTypeId,
			userid: employee.uid,
			gradingFormat:gradingF,
			why:why,
			timeofday:timeofday,
			t1:superApp,
			t2:depHeadApp,
			t3:BCApp,
			tfinal:finalApp
	};
	var xhr = new XMLHttpRequest();
	xhr.open("POST", "submitEvent", true);
	xhr.send(JSON.stringify(eventForm));
	loadEmployeeEvents();
				
}
function loadEmployeeEvents(){
	var xhr = new XMLHttpRequest();
	xhr.open("GET", "loadEmployeeEvents.view", true);
	xhr.send();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			$('#view').html(xhr.responseText);
			getEmployeeEvents();
		}
	}
}
function getEmployeeEvents(){
	var xhr = new XMLHttpRequest();
	xhr.open("GET", "events" , true);
	xhr.send();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			var events = JSON.parse(xhr.responseText);
			if(events.length == 0){
				console.log("you have no events");
				$('#view').html("You have no events")
			}
			else{
				console.log("testing----");
				console.log(events);
				var data = formatTable(events);
				$('#eventTable').DataTable({
					data : data,
					columns: [
						{data : "userid" },
						{data : "type" },
						{data : "gradingFormat" },
						{data : "dateCreated"},
						{data : "dateScheduled"},
						{data : "eventLocation" },
						{data : "descpition" },
						{data : "eventCost" },
						{data : "why" },
						{data : "timeofday" },
						{data : "t1" },
						{data : "t2" },
						{data : "t3" },
						{data : "tfinal" }
						]
				});
				console.log("this should have worked");
				$('#eventTable').show();
			}
		}
	}
}
function formatTable(events){
	console.log("formatting table");
	var data = [];
	for(let i = 0; i < events.length; i++){
		let temp = new Object();
		console.log(events[i]);
		temp.userid = events[i].userid;
		temp.type = events[i].type;
		temp.gradingFormat = events[i].gradingFormat;
		temp.dateCreated = events[i].startD;
		temp.dateScheduled = events[i].endD;
		temp.eventLocation = events[i].loaction;
		temp.descpition = events[i].descpition;
		temp.eventCost = events[i].cost;
		temp.why = events[i].why;
		temp.timeofday = events[i].timeofday;
		temp.t1 = events[i].t1;
		temp.t2 = events[i].t2;
		temp.t3 = events[i].t3;
		temp.tfinal = events[i].tfinal;
		console.log("pop");
		console.log(temp);
		data.push(temp);
	}
	console.log(data);
	return data;
}
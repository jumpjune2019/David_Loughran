/**
 * @param {string} title -	JavaScript Demo
 * @param {string} author - David Loughran
 * @param {string} date -	07/02/2019
 * 
 */


var stackData = [];
var stackID = [];
var stackAF = [];
var score = 0;
var possibleScore = 0;
var dataHolder = [];
var roundCounts = 1;

//Undo
function undo(){											//items are added to stacks through the drop() function. This function simply removes that data from the stacks when called
	var getID = stackID.pop();						//stores information from stacks within temp variables
	var getData = stackData.pop();
	var AFID = stackAF.pop();
	document.getElementById(getID).innerHTML = getData;								//sets information at target div to original value
	document.getElementById(getID).setAttribute('draggable', true);						//re-enables the drag feature on target div
	document.getElementById(AFID).innerHTML = "Place your answer here.";		//replaces the information at at target div to original value
}
	
function init(){											//enables basic functionality of Undo Button
	var undoBtn = document.getElementById("undoB");
	undoBtn.addEventListener("click", undo, false);
}

//Drag and Drop 
function allowDrop(event) {							//allows drop at target div
	event.preventDefault();
}
function drag(event) {									//allows data from draggable div to be moved
	event.dataTransfer.setData("text", event.target.id);
}
function drop(event) {																	//this function not only accepts the draggable items into the drop location but also adds information to stacks for later use
	event.preventDefault();
	var preData = event.target.innerHTML;
	if (preData == "Place your answer here.") {
		var dragDataID = event.dataTransfer.getData("text");
		stackID.push(event.dataTransfer.getData("text"));					//adding ID information to the stack
		//event.target.appendChild(document.getElementById(data)); //this is the old method
		var dragData = document.getElementById(dragDataID);
		event.target.innerHTML = dragData.innerHTML;					// event.target.innerHTML access contents of target div
		
		var attributeGrab = dragData.getAttribute("compare");			//obtains attribute information from draggable div
		event.target.setAttribute("compare", attributeGrab);				//copies attribute from draggable div to drop div
		
		stackAF.push(event.target.id);											//adding data from drop location div to stack
		stackData.push(dragData.innerHTML);									//adding data from draggable div to stack
		dragData.innerHTML = "Empty";											//over writing information at initial draggable div
		dragData.setAttribute('draggable', false);								//disabling drag feature on target div
	}
	
}
	
//Timer in hh:mm:ss
function formatTime(seconds){					//standard timer that starts at 0 and counts up incrementally 
	var h = Math.floor(seconds / 3600), 
		m = Math.floor(seconds / 60) % 60, 
		s = seconds % 60;
	if (h < 10) h = "0" + h;							//the this set of processes is meant to display the elapsed time 
	if (m < 10) m = "0" + m;							//in a more readable format
	if (s < 10) s = "0" + s;
	return h + ":" + m + ":" + s;
}
var count = 0;
var counter; 
function startTimer(){
	counter = setInterval(timer, 1000);
}
function timer() {
	count++;
	document.getElementById('timer').innerHTML = formatTime(count);
}

//Play / End Game / Undo / Play Again Buttons
function change() {
	var val = event.target.getAttribute("value");
	var rc = "Round: " + roundCounts + "/4";
	if (val == "Play"){										//starts the game and retrieves the json file
		val ="End Game";
		roundCounter.setAttribute("value", rc);
		startGame();
		grabFile();
	} else if (val == "End Game" ){						//halts the "Undo" button and drag functions
		val ="Show Score";
		endGame();
	} else if (val == "Show Score"){					//displays the correct answers and gives score
		val ="Play Again";
		scoreBoard();
		if (roundCounts > 4){
			val = "Thank you for playing!";
			myState.setAttribute("disabled", true);
		}
	} else if (val == "Play Again"){						//restarts game, does not retrieve json file
		val ="End Game";
		roundCounter.setAttribute("value", rc);
		startGame();
		modifyData(dataHolder);
	}
	event.target.setAttribute("value", val);
}

//Clean up the play area
function boardReset() {									//resets the css of changed divs
		for (var i = 0; i < 5; i++) {
			var field = "field" + (i + 1);
			var drop = "drop" + (i + 1);
			document.getElementById(field).style.backgroundColor = 'yellow';
			document.getElementById(drop).style.backgroundColor = 'gray';
		}
		//scoreID.setAttribute("value", "Score: ")		//reset the displayed score
		count = 0;													//reset the timer
}

//Display answers
function scoreBoard() {
	var scoreString;
	possibleScore = possibleScore +5;
	for (var i = 0; i < 5; i++) {							//dynamically get the id's of the target divs
		var field = "field" + (i + 1);
		var drop = "drop" + (i + 1);
        var questionCompare = document.getElementById(field).getAttribute('compare');
        var dropCompare = document.getElementById(drop).getAttribute('compare');
        	
        	if(questionCompare == dropCompare){						//checks for correct answers and adds points 
				document.getElementById(field).style.backgroundColor = 'green';
				document.getElementById(drop).style.backgroundColor = 'green';
				score++;
        	}else{																	//checks for incorrect answers
				document.getElementById(field).style.backgroundColor = 'red';
				document.getElementById(drop).style.backgroundColor = 'red';
        	}
	}
	scoreString = "Score: " + score + "/" + possibleScore;												//displays the players score
	scoreID.setAttribute("value", scoreString);								//
	clearUB();																		//empty the Undo button history
}

//Empty the Undo button history
function clearUB(){			
	var temp = stackData.length;
	for (var i= 0 ; i < temp; i++){
		stackID.pop();						
		stackData.pop();
		stackAF.pop();
	}
	
}

//Enables the base game functionality 
function startGame() {
	startTimer();																			//Starts the timer
	dragItem1.setAttribute('draggable', true);									//sets the divs containing the answers to draggable
	dragItem2.setAttribute('draggable', true);
	dragItem3.setAttribute('draggable', true);
	dragItem4.setAttribute('draggable', true);
	dragItem5.setAttribute('draggable', true);
	drop1.innerHTML = "Place your answer here.";							//fills the answer slots with instructions
	drop2.innerHTML = "Place your answer here.";
	drop3.innerHTML = "Place your answer here.";
	drop4.innerHTML = "Place your answer here.";
	drop5.innerHTML = "Place your answer here.";
	drop1.setAttribute("compare", -1);											//ensure that answer slot divs do not have accurate information at game start
	drop2.setAttribute("compare", -1);
	drop3.setAttribute("compare", -1);
	drop4.setAttribute("compare", -1);
	drop5.setAttribute("compare", -1);
	undoB.removeAttribute("disabled");											//enables the Undo button
	boardReset();																		//resets the play space
}

//retrieve the json file
function grabFile(){
	fetch('json/quiz_info_v15.json')										//read in the json file using fetch
	.then(function (response) {
		return response.json();
		console.log("Success");
	})
	.then(function (data) {					
		for (var i=0; i<data.length; i++){								//storing the information retrieved from the json file into a global variable
			dataHolder[i] = data [i];
		}
		shuffle (dataHolder);												//randomizing the global variable
		modifyData(dataHolder);											//sending global variable to be further manipulated
	})
	.catch(function (err) {
		console.log("error" + err);
	});
}

//Primary data manipulation 
function modifyData(data){												
	var quiz = [];
	for (var i=0; i<data.length; i++){								//transfer's the top 5 entries into a separate array
		quiz[i] = data[i];
		dataHolder.shift();
			if (i > 3){
			break;
			}
	}
	var questionArray = [];
	var answerArray = [];
	for (var i = 0; i < quiz.length; i++) {							//separate questions and answers into 2 different arrays
			questionArray.push({
				id: i,
				question: quiz[i].question
			});
			answerArray.push({
				id: i,
				answer: quiz[i].answer
			});
	}

		shuffle(answerArray);										//randomize the answers

		for (var i=0; i<quiz.length; i++) {						//distribute the questions and answers dynamically into the target divs
			var dID = "dragItem" + (i+1);
			var fID = "field" + (i+1);
			document.getElementById(dID).innerHTML = answerArray[i].answer;
			document.getElementById(fID).innerHTML = questionArray[i].question;
			document.getElementById(fID).setAttribute("compare", questionArray[i].id);
			document.getElementById(dID).setAttribute("compare", answerArray[i].id);
		}
}

//Randomize the order of an array 
function shuffle(array){
	array.sort(() => Math.random() - 0.5);
}

//End Game process
function endGame() {										
	clearInterval(counter);									//ending the game must also halt the timer
	dragItem1.setAttribute('draggable', false);		
	dragItem2.setAttribute('draggable', false);		//all elements are draggable="false" when the game starts and must be reset when the game ends
	dragItem3.setAttribute('draggable', false);
	dragItem4.setAttribute('draggable', false);
	dragItem5.setAttribute('draggable', false);
	undoB.setAttribute("disabled", true);			//the undo button must be disabled when the game ends	
	roundCounts = roundCounts + 1;
}
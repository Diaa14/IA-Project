<%-- 
    Document   : HR
    Created on : Dec 21, 2019, 1:25:13 PM
    Author     : Diaa Mamdouh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<title>HR Page</title>
<style>
{box-sizing: border-box;}

/* Button used to open the contact form - fixed at the bottom of the page */
.open-button {
  background-color: #555;
  color: white;
  padding: 16px 20px;
  border: none;
  cursor: pointer;
  opacity: 0.8;
  position: fixed;
  bottom: 23px;
  right: 28px;
  width: 280px;
}

/* The popup form - hidden by default */
.form-popup {
  display: none;
  position: fixed;
  bottom: 0;
  right: 15px;
  border: 3px solid #f1f1f1;
  z-index: 9;
}

/* Add styles to the form container */
.form-container {
  max-width: 300px;
  padding: 10px;
  background-color: white;
}

/* Full-width input fields */
.form-container input[type=text], .form-container input[type=password] {
  width: 100%;
  padding: 15px;
  margin: 5px 0 22px 0;
  border: none;
  background: #f1f1f1;
}

/* When the inputs get focus, do something */
.form-container input[type=text]:focus, .form-container input[type=password]:focus {
  background-color: #ddd;
  outline: none;
}

/* Set a style for the submit/login button */
.form-container .btn {
  background-color: #4CAF50;
  color: white;
  padding: 16px 20px;
  border: none;
  cursor: pointer;
  width: 100%;
  margin-bottom:10px;
  opacity: 0.8;
}

/* Add a red background color to the cancel button */
.form-container .cancel {
  background-color: red;
}

/* Add some hover effects to buttons */
.form-container .btn:hover, .open-button:hover {
  opacity: 1;
}
</style>
</head>
<body>
    

<div class="form-popup" id="myForm">
  <form class="form-container" method="post" action="addExam">
    <h1>Add Exam</h1>

    <label for="exam_name"><b>exam name</b></label>
    <input type="text" placeholder="Enter exam name" name="exam_name" id="exam_name" required>

    <label for="exam_type"><b>exam_topic</b></label>
    <input type="text" placeholder="Enter exam topic" name="exam_topic" id="exam_topic" required>

    <button type="submit" class="btn" id="add_data" >Save Exam</button>
    <button type="submit" class="btn cancel" onclick="closeForm()">Close</button>
  </form>
</div>
    
<div class="form-popup" id="myForm2">
    <form class="form-container" method="post" action="deleteExam">
    <h1>delete exam</h1>

    <label for="exam_name"><b>exam name</b></label>
    <input type="text" placeholder="Enter exam name" name="exam_name" required>

    <label for="exam_type"><b>exam_topic</b></label>
    <input type="text" placeholder="Enter exam topic" name="exam_topic" required>

    <button type="submit" class="btn" >delete Exam</button>
    <button type="submit" class="btn cancel" onclick="closeForm2()">Close</button>
  </form>
</div>
    


<div class="form-popup" id="myForm3">
  <form class="form-container" method="post" action="updateExam">
    <h1>Update Exam</h1>

    <label for="exam_name"><b>exam name</b></label>
    <input type="text" placeholder="Enter exam name" name="exam_name" required>

    <label for="exam_type"><b>exam_topic</b></label>
    <input type="text" placeholder="Enter exam type" name="exam_topic" required>
    
    <label for="NewExam_name"><b>new exam name</b></label>
    <input type="text" placeholder="Enter new exam name" name="NewExam_name" required>
    
    <label for="NewExam_topic"><b>new exam topic</b></label>
    <input type="text" placeholder="Enter new exam topic" name="NewExam_topic" required>

    <button type="submit" class="btn" >Update Exam</button>
    <button type="submit" class="btn cancel" onclick="closeForm3()">Close</button>
  </form>
</div>
    
<div class="form-popup" id="myForm4">
    <form class="form-container" method="post" action="addQuestions">
    
    <input type="text" placeholder="Enter exam id" name="exam_id" required>

    
    <input type="text" placeholder="Enter first question" name="first_question" required>
    
    
    <input type="text" placeholder="Enter second question" name="second_question" required>
    
    
    <input type="text" placeholder="Enter third question" name="third_question" required>
    
    
    <input type="text" placeholder="Enter forth question" name="forth_question" required>
    
    
    <input type="text" placeholder="Enter fifth question" name="fifth_question" required>
    

    <button type="submit" class="btn" id="update_data">Add questions</button>
    <button type="submit" class="btn cancel" onclick="closeForm4()">Close</button>    
    </form>
    </div>

    <div class="form-popup" id="myForm6">
    <form class="form-container" method="post" action="updateQuestions">
    
    <input type="text" placeholder="Enter exam id" name="exam_id" required>

    
    <input type="text" placeholder="Enter new first question" name="first_question" required>
    
    
    <input type="text" placeholder="Enter new second question" name="second_question" required>
    
    
    <input type="text" placeholder="Enter new third question" name="third_question" required>
    
    
    <input type="text" placeholder="Enter new forth question" name="forth_question" required>
    
    
    <input type="text" placeholder="Enter new fifth question" name="fifth_question" required>
    

    <button type="submit" class="btn" id="update_data">Add questions</button>
    <button type="submit" class="btn cancel" onclick="closeForm6()">Close</button>    
    </form>
    </div>
    
    <div class="form-popup" id="myForm5">
    <form class="form-container" method="post" action="addAnswers">
    
    <input type="text" placeholder="Enter exam id" name="exam_id" required>
    
    <input type="number" placeholder="Enter question number" name="question_id" required>

    
    <input type="text" placeholder="Enter first answer" name="first_answer" required>
    <input type="number" placeholder="Enter 1 for correct or 0 for incorrect" name="correct1" type="Boolean" />
    
    
    <input type="text" placeholder="Enter second answer" name="second_answer" required>
    <input type="number" placeholder="Enter 1 for correct or 0 for incorrect" name="correct2" type="Boolean" />    
    
    <input type="text" placeholder="Enter third answer" name="third_answer" required>
    <input type="number" placeholder="Enter 1 for correct or 0 for incorrect" name="correct3" type="Boolean" />    
    
    

    <button type="submit" class="btn" id="update_data">Add answers</button>
    <button type="submit" class="btn cancel" onclick="closeForm5()">Close</button>    
    </form>
    </div>
    
        <div class="form-popup" id="myForm6">
    <form class="form-container" method="post" action="updateQuestions">
    
    <input type="text" placeholder="Enter exam id" name="exam_id" required>

    
    <input type="text" placeholder="Enter new first question" name="first_question" required>
    
    
    <input type="text" placeholder="Enter new second question" name="second_question" required>
    
    
    <input type="text" placeholder="Enter new third question" name="third_question" required>
    
    
    <input type="text" placeholder="Enter new forth question" name="forth_question" required>
    
    
    <input type="text" placeholder="Enter new fifth question" name="fifth_question" required>
    

    <button type="submit" class="btn" >update questions</button>
    <button type="submit" class="btn cancel" onclick="closeForm6()">Close</button>    
    </form>
    </div>
    
    <div class="form-popup" id="myForm7">
    <form class="form-container" method="post" action="updateAnswers">
    
    <input type="text" placeholder="Enter exam id" name="exam_id" required>
    
    <input type="number" placeholder="Enter question number" name="question_id" required>

    
    <input type="text" placeholder="Enter new first answer" name="first_answer" required>
    <input type="number" placeholder="Enter 1 for correct or 0 for incorrect" name="correct1" type="Boolean" />
    
    
    <input type="text" placeholder="Enter new second answer" name="second_answer" required>
    <input type="number" placeholder="Enter 1 for correct or 0 for incorrect" name="correct2" type="Boolean" />    
    
    <input type="text" placeholder="Enter new third answer" name="third_answer" required>
    <input type="number" placeholder="Enter 1 for correct or 0 for incorrect" name="correct3" type="Boolean" />    
    
    

    <button type="submit" class="btn" >Update answers</button>
    <button type="submit" class="btn cancel" onclick="closeForm7()">Close</button>    
    </form>
    </div>
    
<div class="form-popup" id="myForm8">
    <form class="form-container" method="post" action="deleteQuestion">
    <h1>delete question</h1>

    <label for="question_id"><b>question number</b></label>
    <input type="number" placeholder="Enter question number" name="question_id" required>
    
    <button type="submit" class="btn" >delete Question</button>
    <button type="submit" class="btn cancel" onclick="closeForm8()">Close</button>
  </form>
</div>
    
<div class="form-popup" id="myForm9">
    <form class="form-container" method="post" action="deleteAnswer">
    <h1>delete answer</h1>

    <label for="answer_id"><b>answer number</b></label>
    <input type="number" placeholder="Enter answer number" name="answer_id" required>

    <button type="submit" class="btn">delete answer</button>
    <button type="submit" class="btn cancel" onclick="closeForm9()">Close</button>
  </form>
</div>
    
    
    
<div class="container">
    <br> <br>
<div class="row"> 
    <div class="col-md-3"><button onclick="openForm()">Add Exam</button></div>
    <div class="col-md-3"><button onclick="openForm2()">delete Exam</button></div>
    <div class="col-md-3"><button onclick="openForm3()">Update Exam</button></div>
    <div class="col-md-3"><form method="post" action="showExams.jsp"><button type="submit">Show Exams</button></form>
         
   </div>
</div>
    <br> <br>
<div class="row">
<div class="col-md-3">
<button onclick="openForm4()">add Questions</button>
</div>

<div class="col-md-3">

<button onclick="openForm8()">delete Questions</button>
</div>
    
<div class="col-md-3">
<button onclick="openForm6()">update Question</button>
</div>
    
<div class="col-md-3">
<div class="col-md-3"><form method="post" action="showQuestions.jsp"><button type="submit">Show questions</button></form></div>
</div>    
    
</div>
<br> <br>    
<div class="row">
<div class="col-md-3">
<button onclick="openForm5()">add Answers</button>
</div>

<div class="col-md-3">
<button onclick="openForm9()">delete Answers</button>
</div>
    <div class="col-md-3">
    <button onclick="openForm7()">update Answers</button>
    </div>
    
    <div class="col-md-3"><form method="post" action="showAnswers.jsp"><button type="submit">Show answers</button></form> </div>   
    
</div>
<br> <br>
<div class="row">
    <div class="col-md-3">
        <div class="col-md-3"><form method="post" action="showCv.jsp"><button type="submit">Show CV</button></form>
    </div>
</div>
</div>
</body>
<script>
function openForm() {
  document.getElementById("myForm").style.display = "block";
}

function closeForm() {
  document.getElementById("myForm").style.display = "none";
}
function openForm2() {
  document.getElementById("myForm2").style.display = "block";
}

function closeForm2() {
  document.getElementById("myForm2").style.display = "none";
}
function openForm3() {
  document.getElementById("myForm3").style.display = "block";
}

function closeForm3() {
  document.getElementById("myForm3").style.display = "none";
}
function openForm4() {
  document.getElementById("myForm4").style.display = "block";
}

function closeForm4() {
  document.getElementById("myForm4").style.display = "none";
}
function openForm5() {
  document.getElementById("myForm5").style.display = "block";
}

function closeForm5() {
  document.getElementById("myForm5").style.display = "none";
}
function openForm6() {
  document.getElementById("myForm6").style.display = "block";
}

function closeForm6() {
  document.getElementById("myForm6").style.display = "none";
}
function openForm7() {
  document.getElementById("myForm7").style.display = "block";
}

function closeForm7() {
  document.getElementById("myForm7").style.display = "none";
}
function openForm8() {
  document.getElementById("myForm8").style.display = "block";
}

function closeForm8() {
  document.getElementById("myForm8").style.display = "none";
}
function openForm9() {
  document.getElementById("myForm9").style.display = "block";
}

function closeForm9() {
  document.getElementById("myForm9").style.display = "none";
}
</script>
</html>

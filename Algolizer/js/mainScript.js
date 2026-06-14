function createCanvas(width=1200,height=570)
{
let canvas=document.createElement("canvas");
canvas.id="canvas";
canvas.width=width;
canvas.height=height;
let canvasWrapper=document.getElementById("canvasWrapper");
canvasWrapper.appendChild(canvas);
}

function removeCanvas()
{
let canvas=document.getElementById("canvas");
canvas.remove();
}

function isCurrentAlgorithmRunning()
{
let currentAlgorithm=this.visualizer.getCurrentAlgorithm();
if(currentAlgorithm===undefined) return false;
let currentState=currentAlgorithm.getState();
return currentState===AlgorithmState.RUNNING;
}

function setLinearSearchAsCurrentAlgorithm(arr='',elem='')
{
if(isCurrentAlgorithmRunning()) stopCurrentAlgorithm();
clearCanvas();
let array=[];
let element="";
if(arr!='')
{
arr=arr.split(',');
arr.forEach((element)=>element.trim());
arr=arr.filter((element)=>element!=='');
console.log(arr);
array=arr;
element=elem;
}
else
{
array=[1,9,11,123,75,92,22,2,4488,123];
//,123,123,123,123,123,13,132,1,9,11,23,75,92,22,2,4488,123,123,123,123,123,123,13,132]
element=123;
}


let linearSearch=new LinearSearch(array,element);
this.visualizer.setCurrentAlgorithm(linearSearch);
let context=this.visualizer.getContext();
linearSearch.init(context);
}

function setBinarySearchAsCurrentAlgorithm(arr='',elem='')
{
if(isCurrentAlgorithmRunning()) stopCurrentAlgorithm();
clearCanvas();
let array=[];
let element="";
if(arr!='')
{
arr=arr.split(',');
arr.forEach((element)=>element.trim());
arr=arr.filter((element)=>element!=='');
console.log(arr);
array=arr;
element=elem;
}
else
{
array=[1,9,11,23,75,92,148,170,200];
//,1123,1223,1233]
element=148;
}

let binarySearch=new BinarySearch(array,element);
this.visualizer.setCurrentAlgorithm(binarySearch);
let context=this.visualizer.getContext();
binarySearch.init(context);
}

function setDutchNationalFlagAsCurrentAlgorithm(arr='')
{
if(isCurrentAlgorithmRunning()) stopCurrentAlgorithm();
clearCanvas();
let array=[];
if(arr!='')
{
arr=arr.split(',');
arr.forEach((element)=>element.trim());
arr=arr.filter((element)=>element!=='');
console.log(arr);
array=arr;
}
else
{
array=[1,1,0,2,2,0];
}
let dutchNationalFlag=new DutchNationalFlag(array);
this.visualizer.setCurrentAlgorithm(dutchNationalFlag);
let context=this.visualizer.getContext();
dutchNationalFlag.init(context);
}

function setCocktailShakerSortAsCurrentAlgorithm(arr='')
{
if(isCurrentAlgorithmRunning()) stopCurrentAlgorithm();
clearCanvas();
let array=[];
if(arr!='')
{
arr=arr.split(',');
arr.forEach((element)=>element.trim());
arr=arr.filter((element)=>element!=='');
console.log(arr);
array=arr;
}
else
{
array=[10,2,4,6,1,100];
//let array=[10,2,4,6,1];
}
let cocktailShakerSort=new CocktailShakerSort(array);
this.visualizer.setCurrentAlgorithm(cocktailShakerSort);
let context=this.visualizer.getContext();
cocktailShakerSort.init(context);
}

function setSieveOfEratosthenesAsCurrentAlgorithm(sp='',ep='')
{
if(isCurrentAlgorithmRunning()) stopCurrentAlgorithm();
clearCanvas();
let start="";
let end="";
if(sp!="" || ep!="")
{
start=sp;
end=ep;
}
else
{
start=2;
end=12;
}
let sieveOfEratosthenes=new SieveOfEratosthenes(start,end);
this.visualizer.setCurrentAlgorithm(sieveOfEratosthenes);
let context=this.visualizer.getContext();
sieveOfEratosthenes.init(context);
}


function startCurrentAlgorithm()
{
let context=this.visualizer.getContext();
let currentAlgorithm=this.visualizer.getCurrentAlgorithm();
if(currentAlgorithm.getState()===AlgorithmState.FINISHED)
{
console.log(currentAlgorithm.getName());
switch(currentAlgorithm.getName())
{
case LinearSearch.name: setLinearSearchAsCurrentAlgorithm(); break;
case BinarySearch.name: setBinarySearchAsCurrentAlgorithm(); break;
case DutchNationalFlag.name: setDutchNationalFlagAsCurrentAlgorithm(); break;
case CocktailShakerSort.name: setCocktailShakerSortAsCurrentAlgorithm(); break;
case SieveOfEratosthenes.name: setSieveOfEratosthenesAsCurrentAlgorithm(); break;
}
}
this.visualizer.getCurrentAlgorithm().start(context);
}

function stopCurrentAlgorithm()
{
this.visualizer.getCurrentAlgorithm().stop();
}

function getInput()
{
document.getElementById("space").style.display="none";
let currentAlgorithm=this.visualizer.getCurrentAlgorithm();
let currentState=currentAlgorithm.getState();
if(currentState===AlgorithmState.RUNNING)
{
alert("Algorithm is in "+currentState+" state.")
}
else
{
console.log("State : "+currentAlgorithm.getName())
if(currentAlgorithm.getName()==="Sieve Of Eratosthenes")
{
document.getElementById("a").style.margin="0px 0px 0px 0px";
document.getElementById("elm").style.margin="0px 0px 0px 17px";

document.getElementById("a").innerHTML="Starting point";
document.getElementById("elm").innerHTML="Ending point";
document.getElementById("dataContainer").style.display="block";
document.getElementById("element").style.display="block";
}
else if(currentAlgorithm.getName()==="Dutch National Flag" || currentAlgorithm.getName()==="Cocktail Shaker Sort")
{
document.getElementById("a").style.margin="0px 0px 0px 0px";
document.getElementById("a").innerHTML="Array";
document.getElementById("element").style.display="none";
document.getElementById("dataContainer").style.display="block";
}
else
{
document.getElementById("a").style.margin="0px 0px 0px 101px";
document.getElementById("elm").style.margin="0px 0px 0px 0px";
document.getElementById("a").innerHTML="Array";
document.getElementById("elm").innerHTML="Element to search";
document.getElementById("dataContainer").style.display="block";
document.getElementById("element").style.display="block";
}
}
}

function submit()
{
let currentAlgorithm=this.visualizer.getCurrentAlgorithm();
if(currentAlgorithm.getName()==="Sieve Of Eratosthenes")
{
let sp=document.getElementById("val").value;
let ep=document.getElementById("elem").value;
if(!(ep>sp)) alert("Starting point should not be greater than ending point.")
sieveOfEratosthenes(sp,ep);
document.getElementById("val").value="";
ep=document.getElementById("elem").value="";
}
else if(currentAlgorithm.getName()==="Dutch National Flag")
{
let arr=document.getElementById("val").value;
dutchNationalFlag(arr);
document.getElementById("val").value="";
}
else if(currentAlgorithm.getName()==="Cocktail Shaker Sort")
{
let arr=document.getElementById("val").value;
cocktailShakerSort(arr);
document.getElementById("val").value="";
}
else if(currentAlgorithm.getName()==="Linear Search")
{
let arr=document.getElementById("val").value;
let elem=document.getElementById("elem").value;
linearSearch(arr,elem);
document.getElementById("val").value="";
document.getElementById("elem").value="";
}
else if(currentAlgorithm.getName()==="Binary Search")
{
let arr=document.getElementById("val").value;
let elem=document.getElementById("elem").value;
binarySearch(arr,elem);
document.getElementById("val").value="";
document.getElementById("elem").value="";
}
}

function showButtons()
{
document.getElementById("useButton").style.display="block";
let currentAlgorithm=this.visualizer.getCurrentAlgorithm();
document.getElementById("algoName").innerHTML=currentAlgorithm.getName();
document.getElementById("space").style.display="block";
}

function clearInputSet()
{
document.getElementById("dataContainer").style.display="none";
}

function clearCanvas()
{
if(isCurrentAlgorithmRunning()) stopCurrentAlgorithm();
let canvas=document.getElementById("canvas");
let context=canvas.getContext("2d");
context.clearRect(0,0,canvas.width,canvas.height);
}

/*---------------------------------------------------------------------------*/

function resetCanvas(width,height)
{
removeCanvas();
createCanvas(width,height);
let context=document.getElementById("canvas").getContext("2d");
this.visualizer.setContext(context);
}

function linearSearch(arr='',elem='')
{
resetCanvas();
setLinearSearchAsCurrentAlgorithm(arr,elem);
showButtons();
clearInputSet();
}

function binarySearch(arr='',elem='') 
{
resetCanvas();
setBinarySearchAsCurrentAlgorithm(arr,elem);
showButtons();
clearInputSet();
}

function dutchNationalFlag(arr='')
{
resetCanvas();
setDutchNationalFlagAsCurrentAlgorithm(arr);
showButtons();
clearInputSet();
}

function cocktailShakerSort(arr='') 
{
resetCanvas();
setCocktailShakerSortAsCurrentAlgorithm(arr);
showButtons();
clearInputSet();
}

function sieveOfEratosthenes(sp='',ep='') 
{
resetCanvas();
setSieveOfEratosthenesAsCurrentAlgorithm(sp,ep);
showButtons();
clearInputSet();
}

function startAlgorithm() {startCurrentAlgorithm();}

function stopAlgorithm() {stopCurrentAlgorithm();}

function printCurrentAlgorithmState()
{
console.log("State :",this.visualizer.getCurrentAlgorithm().getState());
//Logger.print("State :",this.visualizer.getCurrentAlgorithm().getState());
}

function clearAll(){clearCanvas();}

function createRectangle()
{
let canvas=document.getElementById("canvas");
let context=canvas.getContext("2d");
let stroke=10;
let rectangle=new Rectangle(5,7,300,200);
rectangle.setStroke(stroke);
rectangle.setBorderColor(Color.BLUE);
rectangle.setFillColor(Color.RED);
rectangle.draw(context);
setTimeout(()=>rectangle.clear(context),5000);
Logger.print("after drawing");
Logger.print(context);
}

function createText()
{
let canvas=document.getElementById("canvas");
let context=canvas.getContext("2d");
Logger.print("before drawing text");
Logger.print(context);
let text=new Text(30,50,"Hemant");
text.setBorderColor(Color.GREEN);
text.setSize(30);
let font=new Font("monospace",32,FontStyle.ITALIC);
text.setFont(font);
text.setFillColor(Color.GREEN);
text.draw(context);
setTimeout(()=>text.clear(context),5000);
Logger.print("after drawing text");
Logger.print(context);
}


function createTextRectangle()
{
let canvas=document.getElementById("canvas");
let context=canvas.getContext("2d");
Logger.print("before drawing TextRectangle");
Logger.print(context);
let textRectangle=new TextRectangle(30,50,200,100,"Text Rectangle");
Logger.print('X :',30,", getX() :",textRectangle.getX());
//textRectangle.setTextData("Hemant");
textRectangle.setRectangleStroke(2);
textRectangle.setRectangleFillColor(Color.PURPLE);
textRectangle.setTextColor(Color.YELLOW);
textRectangle.setStroke(10);
textRectangle.draw(context);
setTimeout(()=>textRectangle.clear(context),5000);
Logger.print("after drawingTextRecangle");
Logger.print(context);
}

function createTextRectangleArray()
{
let textRectangleArray=new TextRectangleArray(5,7,50,40,[20,30,5,10]);
textRectangleArray.draw(this.visualizer.getContext(),700);
}

function createCircle()
{
let context=this.visualizer.getContext();
let circle=new Circle(100,100,30);
circle.setStroke(5);
circle.setFillColor(Color.ORANGE);
circle.setBorderColor(Color.PINK);
circle.draw(context);
setTimeout(()=>circle.clear(context),5000);
}

/*---------------------------------------------------------------------------*/

/*
window.addEventListener("load",() => {
Logger.setState(LoggerState.OFF);
this.visualizer=new Visualizer("canvas");
document.getElementById("useButton").disabled = true;
document.getElementById("useButton").style.visibility= "hidden";
});
*/

window.addEventListener("load",() => {
Logger.setState(LoggerState.OFF);
this.visualizer=new Visualizer();
createCanvas();
let context=document.getElementById("canvas").getContext("2d");
this.visualizer.setContext(context);
});
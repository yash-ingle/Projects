class DutchNationalFlag extends Algorithm
{
static name="Dutch National Flag";
constructor(array)
{
super(DutchNationalFlag.name);
Logger.print(this.name);
this.startIndex=0;
this.currentIndex=0;
this.endIndex=array.length-1;
this.array = array;
this.arrayX = 10;
this.arrayY = 100;
this.widthOfOneElement = 100;
this.heightOfOneElement = 100;
}

init(context)
{
this.textRectangleArray=new TextRectangleArray(
this.arrayX,
this.arrayY,
this.widthOfOneElement,
this.heightOfOneElement,
this.array,
ArrayType.HORIZONTAL
);
this.textRectangleArray.draw(context);
}

swap(leftTextRectangle,rightTextRectangle)
{
let leftData=leftTextRectangle.getTextData();
leftTextRectangle.setTextData(rightTextRectangle.getTextData());
rightTextRectangle.setTextData(leftData);
}

markRectangleGreen(rectangle)
{
rectangle.setRectangleBorderColor(Color.BLACK);
rectangle.setRectangleFillColor(Color.GREEN);
rectangle.setTextColor(Color.WHITE);
}

async animateAlgorithm(context)
{
let start=this.startIndex;
let current=this.currentIndex;
let end=this.endIndex;
while(current<=end)
{
if(this.state!==AlgorithmState.RUNNING)
{
this.startIndex=start;
this.currentIndex=current;
this.endIndex=end;
break;
}
let startRectangle=this.textRectangleArray.getTextRectangle(start);
startRectangle.setRectangleBorderColor(Color.PURPLE);
let endRectangle=this.textRectangleArray.getTextRectangle(end);
endRectangle.setRectangleBorderColor(Color.PURPLE);
let currentRectangle=this.textRectangleArray.getTextRectangle(current);
currentRectangle.setRectangleBorderColor(Color.YELLOW);
startRectangle.draw(context);
endRectangle.draw(context);
currentRectangle.draw(context);
await delay(1000);
let currentData=currentRectangle.getTextData();
if(currentData=="2")
{
this.swap(currentRectangle,endRectangle);
this.markRectangleGreen(endRectangle);
currentRectangle.draw(context);
endRectangle.draw(context);
await delay(1000);
end--;
}
if(currentData=="0")
{
this.swap(currentRectangle,startRectangle);
this.markRectangleGreen(startRectangle);
currentRectangle.draw(context);
startRectangle.draw(context);
await delay(1000);
current++;
start++;
}
if(currentData=="1") current++;
}
if(current>end)
{
for(;start<=end;start++)
{
if(this.state!==AlgorithmState.RUNNING)
{
this.startIndex=start;
this.currentIndex=current;
this.endIndex=end;
break;
}
let startRectangle=this.textRectangleArray.getTextRectangle(start);
this.markRectangleGreen(startRectangle);
startRectangle.draw(context);
await delay(1000);
}
if(start>end) super.finish();
}
}

start(context)
{
super.start(context);
Logger.print(this.name, ":", this.state);
this.animateAlgorithm(context);
}

stop()
{
super.stop();
Logger.print(this.name, ":", this.state);
}

}
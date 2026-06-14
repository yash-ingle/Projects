class CocktailShakerSort extends Algorithm
{
static name="Cocktail Shaker Sort";
constructor(array)
{
super(CocktailShakerSort.name);
Logger.print(this.name);
this.startIndex=0;
this.currentIndex=0;
this.endIndex=array.length-1;
this.indicator=true;
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
let indicator=this.indicator;
let start=this.startIndex;
let end=this.endIndex;
let current=this.currentIndex;
while(indicator)
{
if(this.state!==AlgorithmState.RUNNING)
{
this.startIndex=start;
this.endIndex=end;
this.currentIndex=current;
this.indicator=indicator;
break;
}
indicator=false;
for(current=start;current<end;current++)
{
let currentRectangle=this.textRectangleArray.getTextRectangle(current);
let nextRectangle=this.textRectangleArray.getTextRectangle(current+1);
currentRectangle.setRectangleBorderColor(Color.YELLOW);
nextRectangle.setRectangleBorderColor(Color.YELLOW);
currentRectangle.draw(context);
nextRectangle.draw(context);
await delay(1000);
let currentData=Number.parseInt(currentRectangle.getTextData());
let nextData=Number.parseInt(nextRectangle.getTextData());
if(currentData>nextData)
{
indicator=true;
this.swap(currentRectangle,nextRectangle);
currentRectangle.setRectangleBorderColor(Color.BLACK);
nextRectangle.setRectangleBorderColor(Color.BLACK);
currentRectangle.draw(context);
nextRectangle.draw(context);
await delay(1000);
}
}
let endRectangle=this.textRectangleArray.getTextRectangle(end);
this.markRectangleGreen(endRectangle);
endRectangle.draw(context);
end--;
await delay(1000);
if(indicator===false) break;
for(current=end;current>start;current--)
{
let currentRectangle=this.textRectangleArray.getTextRectangle(current);
let previousRectangle=this.textRectangleArray.getTextRectangle(current-1);
currentRectangle.setRectangleBorderColor(Color.YELLOW);
previousRectangle.setRectangleBorderColor(Color.YELLOW);
currentRectangle.draw(context);
previousRectangle.draw(context);
await delay(1000);
let currentData=Number.parseInt(currentRectangle.getTextData());
let previousData=Number.parseInt(previousRectangle.getTextData());
if(current<previousData)
{
indicator=true;
this.swap(currentRectangle,previousRectangle);
currentRectangle.setRectangleBorderColor(Color.BLACK);
previousRectangle.setRectangleBorderColor(Color.BLACK);
currentRectangle.draw(context);
previousRectangle.draw(context);
await delay(1000);
}
}
let startRectangle=this.textRectangleArray.getTextRectangle(start);
this.markRectangleGreen(startRectangle);
startRectangle.draw(context);
start++;
await delay(1000);
}
for(;start<=end;start++)
{
let startRectangle=this.textRectangleArray.getTextRectangle(start);
this.markRectangleGreen(startRectangle);
startRectangle.draw(context);
await delay(1000);
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
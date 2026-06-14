class SieveOfEratosthenes extends Algorithm
{
static name="Sieve Of Eratosthenes";
constructor(start,end)
{
super(SieveOfEratosthenes.name);
Logger.print(this.name);
this.startIndex=start;
this.endIndex=end;
this.currentIndex=0;
let array=[];
for(let x=0,element=start;x<=end-start;x++,element++) array[x]=element;
this.array=array;
this.indicator=true;
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


markRectangleGreen(rectangle)
{
rectangle.setRectangleBorderColor(Color.BLACK);
rectangle.setRectangleFillColor(Color.GREEN);
rectangle.setTextColor(Color.WHITE);
}

markRectangleRed(rectangle)
{
rectangle.setRectangleBorderColor(Color.BLACK);
rectangle.setRectangleFillColor(Color.RED);
rectangle.setTextColor(Color.WHITE);
}

async animateAlgorithm(context)
{
let start=this.startIndex;
let current=this.currentIndex;
let end=this.endIndex;
while(current<=(end-start))
{
if(this.state!==AlgorithmState.RUNNING)
{
this.startIndex=start;
this.currentIndex=current;
this.endIndex=end;
break;
}
let currentRectangle=this.textRectangleArray.getTextRectangle(current);
currentRectangle.setRectangleBorderColor(Color.YELLOW);
let currentData=Number.parseInt(currentRectangle.getTextData());
currentRectangle.draw(context);
await delay(1000);
if(currentData==2) this.indicator=true;
else if(currentData%2==0 || currentData<2) 
{
this.markRectangleRed(currentRectangle);
currentRectangle.draw(context);
await delay(1000);
this.indicator=false;
}
else
{
if(currentData==1) 
{
this.markRectangleRed(currentRectangle);
currentRectangle.draw(context);
await delay(1000);
this.indicator=false;
}
for(let i=3;i*i<=currentData;i+=2)
{
if(currentData%i==0) 
{
this.indicator=false;
this.markRectangleRed(currentRectangle);
currentRectangle.draw(context);
await delay(1000);
break;
}
}
}
if(this.indicator)
{
this.markRectangleGreen(currentRectangle);
currentRectangle.draw(context);
await delay(1000);
}
this.indicator=true;
current++;
}
if(current>end) super.finish();
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
class BinarySearch extends Algorithm
{
static name="Binary Search";
constructor(array,element)
{
super(BinarySearch.name);
Logger.print(this.name);
this.startIndex=0;
this.endIndex=array.length-1;
this.array = array;
this.element = element;
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

async animateAlgorithm(context)
{
let start,end,mid;
for(start=this.startIndex,end=this.endIndex;start<=end;)
{
if(this.state!==AlgorithmState.RUNNING)
{
this.startIndex=start;
this.endIndex=end;
break;
}
let sr=this.textRectangleArray.getTextRectangle(start);
let er=this.textRectangleArray.getTextRectangle(end);
sr.setRectangleBorderColor(Color.YELLOW);
er.setRectangleBorderColor(Color.YELLOW);
sr.draw(context);
er.draw(context);
await delay(1000);
mid=start+Math.floor((end-start)/2);
let mr=this.textRectangleArray.getTextRectangle(mid);
mr.setRectangleBorderColor(Color.PURPLE);
mr.draw(context);
await delay(800);
sr.setRectangleBorderColor(Color.BLACK);
er.setRectangleBorderColor(Color.BLACK);
sr.draw(context);
er.draw(context);
let data=mr.getTextData();
if(data==this.element)
{
mr.setRectangleBorderColor(Color.BLACK);
mr.setRectangleFillColor(Color.GREEN);
mr.setTextColor(Color.WHITE);
mr.draw(context);
await delay(1000);
start=end+1;
break;
}
else
{
mr.setRectangleBorderColor(Color.BLACK);
mr.setRectangleFillColor(Color.RED);
mr.setTextColor(Color.WHITE);
mr.draw(context);
await delay(1000);
if(data<this.element) start=mid+1;
else if(data>this.element) end=mid-1;
}
}
if(start>end) super.finish();
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
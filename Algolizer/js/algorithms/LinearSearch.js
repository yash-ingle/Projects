class LinearSearch extends Algorithm
{
static name="Linear Search";
constructor(array,element)
{
super(LinearSearch.name);
Logger.print(this.name);
this.startIndex=0;
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
let i;
for(i=this.startIndex;i<this.textRectangleArray.getLength();i++)
{
if(this.state!==AlgorithmState.RUNNING)
{
this.startIndex=i;
break;
}
let textRectangle=this.textRectangleArray.getTextRectangle(i);
textRectangle.setBorderColor(Color.YELLOW);
textRectangle.draw(context);
await delay(1000);
if(textRectangle.getTextData()==this.element)
{
textRectangle.setRectangleBorderColor(Color.BLACK);
textRectangle.setRectangleFillColor(Color.GREEN);
textRectangle.setTextColor(Color.WHITE);
textRectangle.draw(context);
await delay(1000);
}
else
{
textRectangle.setRectangleBorderColor(Color.BLACK);
textRectangle.setRectangleFillColor(Color.INDIGO);
textRectangle.setTextColor(Color.WHITE);
textRectangle.draw(context);
await delay(1000);
}
}
if(i===this.array.length) super.finish();
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
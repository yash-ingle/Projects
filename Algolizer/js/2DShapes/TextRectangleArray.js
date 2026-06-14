class TextRectangleArray extends Drawable2DShape
{
constructor(x,y,width,height,array,arrayType=ArrayType.HORIZONTAL)
{
super(x,y);
this.width=width;
this.height=height;
this.arrayType=arrayType;
let textRectangles=[];
let textRectangle;
for(let i=0;i<array.length;i++)
{
if(arrayType===ArrayType.HORIZONTAL)
{
textRectangle=new TextRectangle(x+(i*width),y,width,height,array[i]);
}
else if(arrayType===ArrayType.VERTICAL)
{
textRectangle=new TextRectangle(x,y+(i*height),width,height,array[i]);
}
textRectangles.push(textRectangle);
}
this.textRectangles=textRectangles;
this.length=array.length;
}
getLength()
{
return this.length;
}
setWidth(width)
{
this.width=width;
}
getWidth()
{
return this.width;
}
setHeight(height)
{
this.height=height;
}
getHeight()
{
return this.height;
}
setArrayType(arrayType)
{
this.arrayType=arrayType;
}
getArrayType()
{
return this.arrayType;
}
getTextRectangle(index)
{
return this.textRectangles[index];
}
changeContext(context)
{
let oldContext=super.changeContext(context);
Logger.print("Rectangle changeContext Method");
Logger.print("oldContext :");
Logger.print(oldContext);
return oldContext;
}
revertContextChanges(context,oldContext)
{
super.revertContextChanges(context,oldContext);
}
saveDrawingConfiguration(configuration)
{
super.saveDrawingConfiguration(configuration);
}
clearDrawingConfiguration()
{
super.clearDrawingConfiguration();
}
async draw(context,ms=0)
{
//const oldContext=this.changeContext(context);
this.saveDrawingConfiguration({
x:this.x,
y:this.y,
width:this.width,
height:this.height,
stroke:this.stroke,
textRectangles:this.textRectangles,
});
for(let i=0;i<this.textRectangles.length;i++)
{
let textRectangle=this.textRectangles[i];
textRectangle.draw(context);
if(ms!==0) await delay(ms);
}
//this.revertContextChanges(context,oldContext);
}
clear(context)
{
const conf=this.getDrawingConfiguration();
for(let i=0;i<conf.textRectangles.length;i++)
{
let textRectangle=conf.textRectangles[i];
textRectangle.clear(context);
}
this.clearDrawingConfiguration();
}
}
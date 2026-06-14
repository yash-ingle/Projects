class Text extends Drawable2DShape
{
constructor(x,y,data)
{
super(x,y);
this.data=data;
this.font=new Font("serif",12,FontStyle.NORMAL);
}
setData(data)
{
this.data=data;
}
getData()
{
return this.data;
}
setFont(font)
{
if(font instanceof Font) this.font=font;
else throw "Invalid Font : "+font;
}
getFont()
{
return this.font;
}
setSize(size)
{
this.font.setSize(size);
}
getSize()
{
return this.font.getSize();
}
changeContext(context)
{
let oldContext=super.changeContext(context);
oldContext.font=context.font;
Logger.print(oldContext);
Logger.print("context font before change");
Logger.print(context.font);
context.font=this.font.toString();
Logger.print("context font after change");
Logger.print(context.font);
return oldContext;
}
revertContextChanges(context,oldContext)
{
super.revertContextChanges(context,oldContext);
context.font=oldContext.font;
}
saveDrawingConfiguration(configuration)
{
super.saveDrawingConfiguration(configuration);
}
clearDrawingConfiguration()
{
super.clearDrawingConfiguration();
}
draw(context)
{
const oldContext=this.changeContext(context);
this.saveDrawingConfiguration({
x:this.x,
y:this.y,
stroke:this.stroke,
data:this.data,
font:this.font,
});
Logger.print("Hello Hemant");
Logger.print(context);
if(this.stroke>0) context.strokeText(this.data,this.x,this.y);
context.fillText(this.data,this.x+this.stroke/2,this.y+this.stroke/2);
this.revertContextChanges(context,oldContext);
}
/*
clear(context)
{
const conf=this.getDrawingConfiguration();
const font=context.font;
const fillStyle=context.fillStyle;
const strokeStyle=context.strokeStyle;
context.font=new Font(
conf.font.getFontFamily(),
conf.font.getSize()+1,
conf.font.getStyle()
).toString();
context.fillStyle=Color.WHITE;
context.strokeStyle=Color.WHITE;
context.stroke=conf.stroke+10;
context.strokeText(conf.data,conf.x,conf.y);
context.fillText(conf.data,conf.x+this.stroke/2,this.y+this.stroke/2);
this.clearDrawingConfiguration();
context.font=font;
context.strokeStyle=strokeStyle;
context.fillStyle=fillStyle;
}
*/
}
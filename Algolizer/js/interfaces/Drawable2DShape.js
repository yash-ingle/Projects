class Drawable2DShape
{
constructor(x,y)
{
this.x=x;
this.y=y;
this.stroke=1;
this.borderColor=Color.BLACK;
this.fillColor=Color.WHITE;
this.drawingConfiguration={};
}
setX(x)
{
this.x=x;
}
getX()
{
return this.x;
}
setY(y)
{
this.y=y;
}
getY()
{
return this.y;
}
setStroke(stroke)
{
this.stroke=stroke;
}
getStroke()
{
return this.stroke;
}
setBorderColor(borderColor)
{
this.borderColor=borderColor;
}
getBorderColor()
{
return this.borderColor;
}
setFillColor(fillColor)
{
this.fillColor=fillColor;
}
getFillColor()
{
return this.fillColor;
}
changeContext(context)
{
let oldContext=Object.assign({lineWidth:0,strokeStyle:'',fillStyle:''},context);
Logger.print("Drawable2DShape changeContext Method");
Logger.print(oldContext);
context.lineWidth=this.stroke;
context.strokeStyle=this.borderColor;
context.fillStyle=this.fillColor;
return oldContext;
}
revertContextChanges(context,oldContext)
{
context.lineWidth=oldContext.lineWidth;
context.strokeStyle=oldContext.strokeStyle;
context.fillStyle=oldContext.fillStyle;
}
saveDrawingConfiguration(drawingConfiguration)
{
this.drawingConfiguration=Object.assign(this.drawingConfiguration,drawingConfiguration);
}
getDrawingConfiguration()
{
return Object.assign({},this.drawingConfiguration);
}
clearDrawingConfiguration()
{
this.drawingConfiguration={};
}
draw(context)
{
}
clear(context)
{
}
}
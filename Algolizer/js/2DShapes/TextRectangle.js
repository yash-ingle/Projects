class TextRectangle extends Drawable2DShape
{
constructor(x,y,width,height,data)
{
super(x,y);
this.width=width;
this.height=height;
this.data=data;
this.configureRectangle();
this.configureText();
}
configureRectangle()
{
let rectangle=new Rectangle(this.x,this.y,this.width,this.height);
rectangle.setFillColor(Color.WHITE);
this.rectangle=rectangle;
}
configureText()
{
let text=new Text(this.x,this.y,this.data);
let font=new Font("Arial",20,FontStyle.NORMAL);
text.setFont(font);
text.setStroke(0);
text.setFillColor(Color.BLACK);
this.text=text;
}
setX(x)
{
super.setX(x);
this.rectangle.setX(x);
this.text.setX(x);
}
getX()
{
return this.x;
}
setY(y)
{
super.setY(y);
this.rectangle.setY(y);
this.text.setY(y);
}
getY()
{
return this.y;
}
setWidth(width)
{
this.width=width;
this.rectangle.setWidth(width);
}
getWidth()
{
return this.width;
}
setHeight(height)
{
this.height=height;
this.rectangle.setHeight(height);
}
getHeight()
{
return this.height;
}
setFillColor(fillColor)
{
super.setFillColor(fillColor);
this.rectangle.setFillColor(fillColor);
this.text.setFillColor(fillColor);
}
getFillColor(fillColor)
{
return this.fillColor;
}
setBorderColor(borderColor)
{
super.setBorderColor(borderColor);
this.rectangle.setBorderColor(borderColor);
}
getBorderColor()
{
return this.borderColor;
}
setRectangleStroke(stroke)
{
this.rectangle.setStroke(stroke);
}
getRectangleStroke()
{
return this.rectangle.getStroke();
}
setRectangleBorderColor(borderColor)
{
this.rectangle.setBorderColor(borderColor);
}
getRectangleBorderColor()
{
this.rectangle.getBorderColor();
}
setRectangleFillColor(fillColor)
{
this.rectangle.setFillColor(fillColor);
}
getRectangleFillColor()
{
return this.rectangle.getFillColor();
}
setTextColor(textColor)
{
this.text.setFillColor(textColor);
}
getTextColor()
{
return this.text.getFillColor();
}
setTextData(data)
{
this.data=data;
this.text.setData(data);
}
getTextData()
{
return this.data;
}
changeContext(context)
{
let oldContext=super.changeContext(context);
oldContext.font=context.font;
context.font=this.text.getFont().toString();
return oldContext;
}
revertContextChanges(context,oldContext)
{
super.revertContextChanges(context,oldContext);
context.font=oldContext.font;
}

/*
saveDrawingConfiguration(configuration)
{
super.saveDrawingConfiguration(configuration);
}
clearDrawingConfiguration()
{
super.clearDrawingConfiguration();
}
*/

draw(context)
{
let oldContext=this.changeContext(context);
let metrics=context.measureText(this.data);
let textWidth=metrics.width;
let textHeight=metrics.actualBoundingBoxAscent+metrics.actualBoundingBoxDescent;
this.revertContextChanges(context,oldContext);
Logger.print(textWidth);
Logger.print(this.width);
Logger.print(this.height);
Logger.print(this.x);
let textX=this.getX()+this.rectangle.getWidth()/2-textWidth/2;
let textY=this.getY()+this.rectangle.getHeight()/2+textHeight/2;
this.text.setX(textX);
this.text.setY(textY);
this.revertContextChanges(context,oldContext);
this.rectangle.draw(context);
this.text.draw(context);
}
clear(context)
{
this.text.clear(context);
this.rectangle.clear(context);
}
}
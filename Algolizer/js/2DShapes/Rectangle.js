class Rectangle extends Drawable2DShape
{
constructor(x,y,width,height)
{
super(x,y);
this.width=width;
this.height=height;
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
draw(context)
{
/*
let rectanglePath=new Path2D();
rectanglePath.rect(this.x,this.y,this.width,this.height);
let rectangleFillPath=new Path2D();
rectangleFillPath.rect(
this.x+this.stroke/2,
this.y+this.stroke/2,
this.width-this.stroke,
this.height-this.stroke
);
const oldContext=this.changeContext(context);
this.saveDrawingConfiguration({
x:this.x,
y:this.y,
width:this.width,
height:this.height,
stroke:this.stroke,
rectanglePath:rectanglePath,
rectangleFillPath:rectangleFillPath,
});
*/
const oldContext=this.changeContext(context);
this.saveDrawingConfiguration({
x:this.x,
y:this.y,
width:this.width,
height:this.height,
stroke:this.stroke,
});
Logger.print("super.fillColor : ",super.fillColor);
Logger.print("this.fillColor : ",this.fillColor);
Logger.print("Rectangle context:");
Logger.print(context);
if(this.stroke>0) context.strokeRect(this.x,this.y,this.width,this.height);
context.fillRect(
this.x+this.stroke/2,
this.y+this.stroke/2,
this.width-this.stroke,
this.height-this.stroke
);
/*
if(this.stroke>0) context.stroke(rectanglePath);
context.fill(rectangleFillPath);
*/
this.revertContextChanges(context,oldContext);
}
clear(context)
{
const conf=this.getDrawingConfiguration();
context.clearRect(
conf.x-conf.stroke,
conf.y-conf.stroke,
conf.width+(2*conf.stroke),
conf.height+(2*conf.stroke)
);
/*
context.save();
context.clip(conf.rectanglePath);
context.clearRect(
conf.x-conf.stroke,
conf.y-conf.stroke,
conf.width+(2*conf.stroke),
conf.height+(2*conf.stroke)
);
context.restore();
*/
this.clearDrawingConfiguration();
}
}
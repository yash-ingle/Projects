class <class-name> extends Drawable2DShape
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
console.log("Rectangle changeContext Method");
console.log("oldContext :");
console.log(oldContext);
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
const oldContext=this.changeContext(context);
this.saveDrawingConfiguration({
x:this.x,
y:this.y,
width:this.width,
height:this.height,
stroke:this.stroke,
});
context.strokeRect(this.x,this.y,this.width,this.height);
context.fillRect(
this.x+this.stroke/2,
this.y+this.stroke/2,
this.width-this.stroke,
this.height-this.stroke
);
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
this.clearDrawingConfiguration();
}
}
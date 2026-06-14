class Circle extends Drawable2DShape
{
constructor(x,y,radius)
{
super(x,y);
this.radius=radius;
}
setRadius(radius)
{
this.radius=radius;
}
getRadius()
{
return this.radius;
}
changeContext(context)
{
let oldContext=super.changeContext(context);
Logger.print("Circle ChangeContext Method");
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
const oldContext=this.changeContext(context);
this.saveDrawingConfiguration({
x:this.x,
y:this.y,
radius:this.radius,
stroke:this.stroke,
});
Logger.print("Circle context:");
Logger.print(context);

let circlePath = new Path2D();
circlePath.arc(this.x,this.y,this.radius, 0, 2 * Math.PI);
if(this.stroke>0) context.stroke(circlePath);
context.fill(circlePath);

this.revertContextChanges(context,oldContext);
}
/*
clear(context)
{
console.log("clear");
const conf=this.getDrawingConfiguration();
let modifiedRadius=conf.radius+conf.stroke-2;
context.strokeStyle=Color.RED;
context.lineWidth=1;
context.beginPath();
context.arc(conf.x,conf.y,modifiedRadius,0,2*Math.PI);
context.stroke();
context.closePath();
this.clearDrawingConfiguration();
}
*/
clear(context)
{
const conf=this.getDrawingConfiguration();
let circlePath = new Path2D();
let modifiedRadius=conf.radius+conf.stroke-1;
circlePath.arc(conf.x,conf.y,modifiedRadius, 0, 2 * Math.PI);
context.save();
context.clip(circlePath);
context.clearRect(
conf.x-modifiedRadius,
conf.y-modifiedRadius,
2*modifiedRadius,
2*modifiedRadius
);
context.restore();
this.clearDrawingConfiguration();
}

}
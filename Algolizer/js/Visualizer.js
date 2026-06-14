class Visualizer
{
constructor(canvasId,algorithm)
{
if(algorithm!==undefined) this.currentAlgorithm=algorithm;
if(canvasId!==undefined) this.context=document.getElementById(canvasId).getContext("2d")
}
setCurrentAlgorithm(currentAlgorithm)
{
this.currentAlgorithm=currentAlgorithm;
}
getCurrentAlgorithm()
{
return this.currentAlgorithm;
}
setContext(context)
{
this.context=context;
}
getContext()
{
return this.context;
}
}
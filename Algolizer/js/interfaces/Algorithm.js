class Algorithm
{

constructor(name)
{
this.state=AlgorithmState.IDLE;
this.name=name;
}
start()
{
if(this.state===AlgorithmState.RUNNING) throw this.name+" is already in running state";
this.state=AlgorithmState.RUNNING;
}

finish()
{
if(this.state===AlgorithmState.FINISHED) throw this.name+" is already in finished state";
this.state=AlgorithmState.FINISHED;
}

stop()
{
if(this.state!==AlgorithmState.RUNNING) throw this.name+" is not in running state";
this.state=AlgorithmState.TERMINATED;
}

getState()
{
return this.state;
}

getName()
{
return this.name;
}

}
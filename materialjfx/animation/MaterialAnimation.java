package materialjfx.animation;

import javafx.animation.Animation.Status;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.SequentialTransition;
import javafx.animation.Timeline;
import javafx.beans.property.*;
import javafx.beans.value.WritableValue;
import javafx.collections.ObservableList;
import javafx.collections.ObservableMap;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.util.Duration;

@SuppressWarnings("rawtypes")
public class MaterialAnimation {
	Timeline t = new Timeline();
	SequentialTransition st;
	Duration time;
	WritableValue value;
	
	Interpolator interpolator;
	double startValue, endValue, di;
	int cycles;
	boolean shiftStarted = false;
	
	//Output Methods
	@SuppressWarnings("unchecked")
	public Timeline toTimeline() {
		t = new Timeline(new KeyFrame(time, new KeyValue(value, startValue), new KeyValue(value, endValue, interpolator)));
		t.setCycleCount(cycles);
		return t;}
	
	public Duration                                 	getDuration()     {return t.getCycleDuration();}
	public WritableValue                            	getValue()        {return value;}
	public Interpolator                             	getInterpolator() {return interpolator;}
	
	public BooleanProperty                          	autoReverseProperty()   {return t.autoReverseProperty();}
	public ReadOnlyDoubleProperty                   	currentRateProperty()   {return t.currentRateProperty();}
	public ReadOnlyObjectProperty<?>                	currentTimeProperty()   {return t.currentTimeProperty();}
	public IntegerProperty                          	cycleCountProperty()    {return t.cycleCountProperty();}
	public ReadOnlyObjectProperty<Duration>         	cycleDurationProperty() {return t.cycleDurationProperty();}
	public ReadOnlyObjectProperty<Duration>         	delayProperty()         {return t.delayProperty();}
	public ObservableMap<String, Duration>          	getCuePoints(Object o)  {return t.getCuePoints();}
	public double                                   	getCurrentRate()        {return t.getCurrentRate();}
	public Duration                                 	getCurrentTime()        {return t.getCurrentTime();}
	public int                                     		getCycleCount()         {return cycles;}
	public Duration                                 	getCycleDuration()      {return t.getCycleDuration();}
	public Duration		                            	getDelay()              {return t.getDelay();}
	public ObservableList<KeyFrame>            	    	getKeyFrames()          {return t.getKeyFrames();}
	public EventHandler<ActionEvent>                	getOnFinished()         {return t.getOnFinished();}
	public double                                   	getRate()               {return t.getRate();}
	public Status                                   	getStatus()             {return t.getStatus();}
	public double                                   	getTargetFramerate()    {return t.getTargetFramerate();}
	public Duration                                 	getTotalDuration()      {return t.getTotalDuration();}
	public int		                                	hashCode()              {return t.hashCode();}
	public boolean                                  	isAutoReverse()         {return t.isAutoReverse();}
	public ObjectProperty<EventHandler<ActionEvent>>	onFinishedProperty()    {return t.onFinishedProperty();}
	public DoubleProperty                           	rateProperty()          {return t.rateProperty();}
	public ReadOnlyObjectProperty<Status>           	statusProperty()        {return t.statusProperty();}
	public String                                   	toString()              {return t.toString();}
	public ReadOnlyObjectProperty<Duration>         	totalDurationProperty() {return t.totalDurationProperty();}
	
	//Comparison Methods
	public boolean                                  	equals(Object obj) {return t.equals(obj);}
	public boolean                                  	isPlaying()        {return shiftStarted;}
	public boolean                                  	isPaused()         {return (shiftStarted == false);}
	
	//Modify or Act
	public void                                     	setDuration(Duration time)                 {this.time = time;}
	public void                                     	setProperty(WritableValue value)           {this.value = value;}
	public void		                                	setInterpolator(Interpolator interpolator) {this.interpolator = interpolator;}
	
	public void                                     	jumpTo(Duration time)                          {t.jumpTo(time);}
	public void                                     	jumpTo(String cuePoint)                        {t.jumpTo(cuePoint);}
	public void                                     	playFrom(Duration time)                        {t.playFrom(time);}
	public void                                     	playFrom(String cuePoint)                      {t.playFrom(cuePoint);}
	public void                                     	playFromStart()                                {t.playFromStart();}
	public void                                     	setAutoReverse(boolean value)                  {t.setAutoReverse(value);}
	public void                                     	setCycleCount(int value)                       {this.cycles = value;}
	public void                                     	setOnFinished(EventHandler<ActionEvent> value) {t.setOnFinished(value);}
	
	
	//Constructors
	public MaterialAnimation() {
		time = Duration.seconds(1);
		interpolator = Interpolator.LINEAR;
		cycles = 1;
	}
	public MaterialAnimation(WritableValue value, double startValue, double endValue) {
		time = Duration.seconds(1);
		this.value = value;
		this.startValue = startValue;
		this.endValue = endValue;
		interpolator = Interpolator.LINEAR;
		
		cycles = 1;
	}
	public MaterialAnimation(WritableValue value, double startValue, double endValue, Duration time) {
		this.value = value;
		this.startValue = startValue;
		this.endValue = endValue;
		this.time = time;
		interpolator = Interpolator.LINEAR;
		
		cycles = 1;
	}
	public MaterialAnimation(WritableValue value, double startValue, double endValue, Duration time, Interpolator interpolator) {
		this.value = value;
		this.startValue = startValue;
		this.endValue = endValue;
		this.time = time;
		this.interpolator = interpolator;
		
		cycles = 1;
	}
	public MaterialAnimation(WritableValue value, double startValue, double endValue, Duration time, int cycles) {
		this.value = value;
		this.startValue = startValue;
		this.endValue = endValue;
		this.time = time;
		interpolator = Interpolator.LINEAR;
		
		this.cycles = cycles;
	}
	
	public MaterialAnimation(WritableValue value, double startValue, double endValue, Duration time, int cycles, Interpolator interpolator) {
		this.value = value;
		this.startValue = startValue;
		this.endValue = endValue;
		this.time = time;
		this.interpolator = interpolator;
		
		this.cycles = cycles;
	}

	@SuppressWarnings("unchecked")
	public void play() {
		if (!shiftStarted) t = new Timeline(new KeyFrame(time, new KeyValue(value, startValue), new KeyValue(value, endValue, interpolator)));
		shiftStarted = true;
		t.setAutoReverse(true);
		t.setCycleCount(cycles);
		t.play();
	}
	@SuppressWarnings("unchecked")
	public MaterialAnimation start() {
		if (!shiftStarted) t = new Timeline(new KeyFrame(time, new KeyValue(value, startValue), new KeyValue(value, endValue, interpolator)));
		shiftStarted = true;
		t.setAutoReverse(true);
		t.setCycleCount(cycles);
		t.play();
		
		return this;
	}
	public void pause() {t.pause();}
	public void stop() {t.stop(); shiftStarted = false;}
}
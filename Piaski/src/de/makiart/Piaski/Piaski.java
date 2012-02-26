package de.makiart.Piaski;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

import android.app.Activity;
import android.opengl.GLSurfaceView;
import android.opengl.GLSurfaceView.Renderer;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.Window;
import android.view.WindowManager;
import de.makiart.Piaski.states.GameState;
import de.makiart.Piaski.states.MenuState;
import de.makiart.engine.ServiceLocator;
import de.makiart.engine.events.ChangeStateEvent;
import de.makiart.engine.events.EventService;
import de.makiart.engine.events.SimpleEvent;
import de.makiart.engine.events.SimpleEventListener;
import de.makiart.engine.state.StateService;

public class Piaski extends Activity implements Renderer, OnTouchListener {

	private GLSurfaceView mSurfaceView;
	private ServiceLocator mCore;
	
	private boolean mIsTouched;
	private float mTouchY;
	private float mTouchX;
	
	private long mCurrentTime;
	private long mDeltaTime;
	private long mOldTime;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {  	
        super.onCreate(savedInstanceState);
        
        //    	Landscape Modus und Fullscreen einstellen
        requestWindowFeature(Window.FEATURE_NO_TITLE); 
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN);         
        
        // OpenGL SurfaceView initialisieren
        mSurfaceView	=	new	GLSurfaceView(this);
        mSurfaceView.setRenderer(this);
        setContentView(mSurfaceView);     
        mSurfaceView.setOnTouchListener(this);
        
        //	Initialisieren des cores
        mCore	=	new ServiceLocator();
        
        setup();
    }
	
    public void onDrawFrame(GL10 arg0) {
    	mCurrentTime = System.nanoTime(); 
    	mDeltaTime = mCurrentTime - mOldTime;
    	mOldTime = mCurrentTime; 

    	mCore.update(mDeltaTime);

	}
	
	public void onSurfaceChanged(GL10 gl, int width, int height) {
		// TODO Auto-generated method stub
		
	}
	
	public void onSurfaceCreated(GL10 gl, EGLConfig config) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	protected void onPause() {
		super.onPause();
		mSurfaceView.onPause();
	}
	
	@Override
	protected void onResume() {
		super.onResume();
		mSurfaceView.onResume();
	}
	
	public boolean onTouch(View v, MotionEvent event) {
		switch (event.getAction()) {
		case	MotionEvent.ACTION_DOWN:
		case 	MotionEvent.ACTION_MOVE:
			mTouchX	=	event.getX();
			mTouchY	=	event.getY();
			mIsTouched	=	true;
			Log.d("Touch-EVENT Down", "X: " + mTouchX + " | Y: " + mTouchY);
			break;
		case	MotionEvent.ACTION_UP:
			mIsTouched	=	false;
			Log.d("Touch-EVENT Up", "X: " + mTouchX + " | Y: " + mTouchY);

			//((EventService) mCore.getService("EventService")).dispatchEvent(new SimpleEvent());
			ChangeStateEvent	cse	=	new ChangeStateEvent();
			cse.setTarget("MenuState");
			((EventService) mCore.getService("EventService")).dispatchEvent(cse);
			break;
		}		
		return true;
	}
	
	/**
	 * Initialisieren von Services und States. Startet mit dem "MenusState" als Initial State.
	 */
	private void setup() {
		mCore.addService(new EventService());
		mCore.addService(new StateService());
		
		StateService stateService = (StateService) mCore.getService("StateService");
		stateService.addState(new MenuState(mCore));
		stateService.addState(new GameState(mCore));
		stateService.changeState("MenuState");
		
//        SimpleEventListener sel = new SimpleEventListener();
//        ((EventService) mCore.getService("EventService")).addListener(sel);        
//        mCore.getService("EventService").start();
	}
}
package de.makiart.Piaski;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

import android.app.Activity;
import android.opengl.GLSurfaceView;
import android.opengl.GLSurfaceView.Renderer;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.Window;
import android.view.WindowManager;
import de.makiart.Piaski.states.GameState;
import de.makiart.engine.ServiceLocator;
import de.makiart.engine.events.EventService;
import de.makiart.engine.state.StateService;
import de.makiart.engine.view.ViewService;

public class Piaski extends Activity implements OnTouchListener, Renderer {

	private GLSurfaceView mSurfaceView;
	
	private ServiceLocator mCore;
	private boolean isRunning;
	
	private int mWidth;
	private int mHeight;
	
	private boolean mIsTouched;
	private float mTouchY;
	private float mTouchX;
	
	private long mCurrentTime;
	private long mDeltaTime;
	private long mOldTime;
	
	private ViewService mViewService;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {  	
        super.onCreate(savedInstanceState);
        setup();
        startGame();
    }
    
    private void startGame() {
    	// Game loop
//    	while(isRunning) {
//    		processInput();
//    		simulateWorld();
//    		renderWorld();   		
//    		
//    	}
	}
	
	private void renderWorld(GL10 gl) {
		mViewService.render(gl);
    	
		
	}

	private void simulateWorld() {
		mDeltaTime = mCurrentTime - mOldTime;
    	mOldTime = mCurrentTime; 
    	mCore.update(mDeltaTime);		
	}

	private void processInput() {
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
			
			mTouchX	=	event.getX();
			mTouchY	=	event.getY();
			
			

			//((EventService) mCore.getService("EventService")).dispatchEvent(new SimpleEvent());
//			ChangeStateEvent	cse	=	new ChangeStateEvent();
//			cse.setTarget("MenuState");
//			((EventService) mCore.getService("EventService")).dispatchEvent(cse);
			break;
		}		
		return true;
	}
	
	/**
	 * Initialisieren von Services und States. Startet mit dem "MenusState" als Initial State.
	 */
	private void setup() {
        //    	Landscape Modus und Fullscreen einstellen
        requestWindowFeature(Window.FEATURE_NO_TITLE); 
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN);
        
        // 		Bildschirm breite/höhe
        Display display = getWindowManager().getDefaultDisplay();
        mWidth 	= 	display.getWidth();
        mHeight = 	display.getHeight();
                
        //		Initialisieren des cores
        mCore	=	new ServiceLocator();
		
        //		Hinzufügen der Services
		mCore.addService(new EventService());
		mCore.addService(new StateService());
		mViewService = new ViewService();
		mCore.addService(mViewService);		

        // 		OpenGL SurfaceView initialisieren
        mSurfaceView	=	new	GLSurfaceView(this);
        mSurfaceView.setRenderer(this);
        setContentView(mSurfaceView);     
        mSurfaceView.setOnTouchListener(this);
		
        // 		Spielzustände hinzufügen
		StateService stateService = (StateService) mCore.getService("StateService");
		stateService.addState(new GameState(mCore));
		stateService.changeState(GameState.NAME);		
		
		isRunning = true;
	}

	public void onDrawFrame(GL10 gl) {
		if (isRunning) {
			processInput();
			simulateWorld();
			renderWorld(gl); 
		}
		
	}

	public void onSurfaceChanged(GL10 gl, int width, int height) {
		mWidth = width;
		mHeight = height;
		gl.glViewport(0, 0, width, height);
		
	}

	public void onSurfaceCreated(GL10 gl, EGLConfig config) {
		gl.glViewport(0, 0, mWidth, mHeight);
		gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		gl.glMatrixMode(GL10.GL_PROJECTION);
		
//		float ratio = mWidth / mHeight;
		gl.glLoadIdentity();
		
		gl.glOrthof(
			0,				//	left
			mWidth , 		//	right
			0, 				//	bottom
			mHeight, 		//	top
			1 , 			//	near
			-1				//	far
		);
		
		gl.glClearColor(0, 0, 0, 1.0f);
		
		gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
	   	gl.glEnableClientState(GL10.GL_COLOR_ARRAY);

		
	}
}
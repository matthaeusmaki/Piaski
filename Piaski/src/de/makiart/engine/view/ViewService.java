package de.makiart.engine.view;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.ArrayList;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

import android.opengl.GLSurfaceView.Renderer;
import android.util.Log;
import de.makiart.engine.AbstractService;

public class ViewService extends AbstractService implements Renderer {

	public static final String NAME = "ViewService";
	
	private int mWidth;
	private int mHeight;
	
	private ArrayList<AbstractView> mViewList = new ArrayList<AbstractView>();
	
	public ViewService(int width, int height) {
		super(NAME);
		mWidth = width;
		mHeight = height;
	}
	
	public void addView(AbstractView view) {
		mViewList.add(view);
	}
	
	public void removeAllViews() {
		for(AbstractView view : mViewList) {
			view.removeAllComponents();
		}
		mViewList.clear();
	}

	public void onDrawFrame(GL10 gl) {
		gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
//		test(gl);
		for(AbstractView view : mViewList) {
			view.drawAll(gl);
		}
	}

	public void onSurfaceChanged(GL10 gl, int width, int height) {
		mWidth = width;
		mHeight = height;
		gl.glViewport(0, 0, width, height);
	}

	public void onSurfaceCreated(GL10 gl, EGLConfig config) {
		Log.d(NAME + ".onSurfaceCreated", "Initialisierung von OpenGL");
		
		gl.glViewport(0, 0, mWidth, mHeight);
		gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		gl.glMatrixMode(GL10.GL_PROJECTION);
		
		float ratio = mWidth / mHeight;
		gl.glLoadIdentity();
//		gl.glOrthof(
//				-500,				//	left
//				500 , 				//	right
//				-500, 				//	bottom
//				500, 				//	top
//				1 , 				//	near
//				-1					//	far
//				);
		
		gl.glOrthof(
		0,				//	left
		mWidth , 				//	right
		0, 				//	bottom
		mHeight, 				//	top
		1 , 				//	near
		-1					//	far
		);
		
		
		//gl.glMatrixMode(GL10.GL_MODELVIEW);
//		gl.glEnable(GL10.GL_DEPTH_TEST);
		
		gl.glClearColor(0, 0, 0, 1.0f);
		
		gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
	   	gl.glEnableClientState(GL10.GL_COLOR_ARRAY);
	   	
//	   	test(gl);
	}
	
	private void test(GL10 gl) {
		// fürs debuggen, ein Dreieck
		ByteBuffer buffer = ByteBuffer.allocateDirect(4 * 4 * 3);
		buffer.order(ByteOrder.nativeOrder());
		FloatBuffer mVertices = buffer.asFloatBuffer();
		
		mVertices.put(-0.5f);
		mVertices.put(-0.5f);
		
		mVertices.put(0.5f);
		mVertices.put(-0.5f);
		
		mVertices.put(0);
		mVertices.put(0.5f);
		
		mVertices.rewind();
		
		buffer = ByteBuffer.allocateDirect(3 * 4 * 4);
		buffer.order(ByteOrder.nativeOrder());
		FloatBuffer mColors = buffer.asFloatBuffer();
		
		mColors.put(1);
		mColors.put(0);
		mColors.put(0);
		mColors.put(1);
		
		mColors.put(0);
		mColors.put(1);
		mColors.put(0);
		mColors.put(1);
		
		mColors.put(0);
		mColors.put(0);
		mColors.put(1);
		mColors.put(1);
		
		mColors.rewind();
		
		gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
		gl.glVertexPointer(2, GL10.GL_FLOAT, 0, mVertices);
		
		gl.glEnableClientState(GL10.GL_COLOR_ARRAY);
		gl.glColorPointer(4, GL10.GL_FLOAT, 0, mColors);
		
		gl.glDrawArrays(GL10.GL_TRIANGLE_STRIP, 0, 3);
	}
}

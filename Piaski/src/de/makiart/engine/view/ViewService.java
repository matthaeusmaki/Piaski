package de.makiart.engine.view;

import java.util.ArrayList;

import javax.microedition.khronos.opengles.GL10;

import de.makiart.engine.AbstractService;

public class ViewService extends AbstractService {

	public static final String NAME = "ViewService";
	private GL10 mGl;
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
	
	public void setGL(GL10 gl) {
		mGl = gl;
	}

	@Override
	public void update() {
		super.update();
		mGl.glViewport(0, 0, mWidth, mHeight);		
		mGl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		
//		drawTriangle();
		
		for(AbstractView view : mViewList) {
			view.drawAll(mGl);
		}
	}

//	private void drawTriangle() {
//		// fürs debuggen, ein Dreieck
//		ByteBuffer buffer = ByteBuffer.allocateDirect(4 * 4 * 3);
//		buffer.order(ByteOrder.nativeOrder());
//		FloatBuffer mVertices = buffer.asFloatBuffer();
//		
//		mVertices.put(-0.5f);
//		mVertices.put(-0.5f);
//		
//		mVertices.put(0.5f);
//		mVertices.put(-0.5f);
//		
//		mVertices.put(0);
//		mVertices.put(0.5f);
//		
//		mVertices.rewind();
//		
//		buffer = ByteBuffer.allocateDirect(3 * 4 * 4);
//		buffer.order(ByteOrder.nativeOrder());
//		FloatBuffer mColors = buffer.asFloatBuffer();
//		
//		mColors.put(1);
//		mColors.put(0);
//		mColors.put(0);
//		mColors.put(1);
//		
//		mColors.put(0);
//		mColors.put(1);
//		mColors.put(0);
//		mColors.put(1);
//		
//		mColors.put(0);
//		mColors.put(0);
//		mColors.put(1);
//		mColors.put(1);
//		
//		mColors.rewind();
//		
//		mGl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
//		mGl.glVertexPointer(2, GL10.GL_FLOAT, 0, mVertices);
//		
//		mGl.glEnableClientState(GL10.GL_COLOR_ARRAY);
//		mGl.glColorPointer(4, GL10.GL_FLOAT, 0, mColors);
//		
//		mGl.glDrawArrays(GL10.GL_TRIANGLE_STRIP, 0, 3);
//	}
}

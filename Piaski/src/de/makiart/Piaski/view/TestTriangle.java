package de.makiart.Piaski.view;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

import javax.microedition.khronos.opengles.GL10;

import de.makiart.engine.view.ViewComponent;

public class TestTriangle extends ViewComponent {

	@Override
	protected void draw(GL10 gl) {
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

package de.makiart.engine.view;

import javax.microedition.khronos.opengles.GL10;

public class Square extends Shape {
	
	public Square() {
		float vertices[] = {
				0.0f, 0.0f,  0.0f,       // V1 - bottom left				
				0.0f,  100.0f,  0.0f,       // V2 - top left
				100.0f, 0.0f,  0.0f,        // V3 - bottom right
				100.0f,  100.f,  0.0f         // V4 - top right
		};
		super.setVertices(vertices);
		
		super.setColor(0.0f, 1.0f, 0.0f, 1.0f);
		
		short[]	indices	=	new short[] {
				3, 1, 0,
				0, 2, 3
		};
		super.setIndices(indices);
		
		
	}
	
	public Square(float[] vertices ) {
		super.setVertices(vertices);
		
		short[]	indices	=	new short[] {
				3, 1, 0,
				0, 2, 3
		};		
		super.setIndices(indices);
		
		
		
	}
	/*
	public Square(float[] vertices, short[] indices, float[] colors ) {
		super.setVertices(vertices);
		super.setIndices(indices);
		super.setColors(colors);
	}
	*/
	/*
	public void draw(GL10 gl) {
    	gl.glVertexPointer(3, GL10.GL_FLOAT, 0, super.verticesBuffer);
        //gl.glColorPointer(4, GL10.GL_FLOAT, 0, colorBuffer);
    	gl.glColor4f(super.rgba[0], super.rgba[1], super.rgba[2], super.rgba[3]);
    	
    	// Draw the vertices as triangle strip
    	gl.glDrawArrays(GL10.GL_TRIANGLE_STRIP, 0, 4);

        //gl.glDrawElements(GL10.GL_TRIANGLES, numOfIndices, GL10.GL_UNSIGNED_SHORT, indicesBuffer);
    	
    	//Disable the client state before leaving
    	gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);

    }
    */
	
	
}

package de.makiart.Piaski;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Menu extends Activity {

	
    public void onCreate(Bundle savedInstanceState) {  	
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);
        
        Button	startGameButton	=	(Button)	findViewById(R.id.StartGame);
        startGameButton.setOnClickListener(new OnClickListener() {
        
		    public void onClick(View v) {
		    	Intent StartGameIntent	=	new Intent(Menu.this, Piaski.class);
		    	startActivity(StartGameIntent);
		    }
        });
    }
    
	
}

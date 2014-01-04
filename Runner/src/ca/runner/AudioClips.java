package ca.runner;

import java.util.HashMap;

import android.app.Activity;
import android.content.Context;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;

public class AudioClips extends Activity {

	private SoundPool soundPool;
    private HashMap<Integer, Integer> soundsMap;
    int SOUND1=1;
    int SOUND2=2; 
 
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        soundPool = new SoundPool(4, AudioManager.STREAM_MUSIC, 100);
        soundsMap = new HashMap<Integer, Integer>();
        soundsMap.put(SOUND1, soundPool.load(this, R.raw.supermariocoinnoise, 1));
        soundsMap.put(SOUND2, soundPool.load(this, R.raw.sheephighscore, 1));
    }
 
        public void playSound(int sound, float fSpeed) {
        AudioManager mgr = (AudioManager)getSystemService(Context.AUDIO_SERVICE);
        float streamVolumeCurrent = mgr.getStreamVolume(AudioManager.STREAM_MUSIC);
        float streamVolumeMax = mgr.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        float volume = streamVolumeCurrent / streamVolumeMax;  
 
        soundPool.play(soundsMap.get(sound), volume, volume, 1, 0, fSpeed);
       }
}

package coffeemachine;
import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;
import com.sun.speech.freetts.audio.JavaClipAudioPlayer;

public class Speaker{
  public static void say(String str){
    new Thread(){
      public void run(){
        String voiceName = "kevin16";
        VoiceManager voiceManager = VoiceManager.getInstance();
        Voice helloVoice = voiceManager.getVoice(voiceName);
        helloVoice.allocate();
        helloVoice.speak(str);
        helloVoice.deallocate();
      }
    }.start();
  }
}

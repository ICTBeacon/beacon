package beacon.ringers.com.beacon;

import android.support.v7.app.AppCompatActivity;

import com.perples.recosdk.RECOBeaconManager;
import com.perples.recosdk.RECOErrorCode;
import com.perples.recosdk.RECOServiceConnectListener;

/**
 * Created by kk070 on 2016-03-03.
 */
public class TestClass extends AppCompatActivity implements RECOServiceConnectListener {
    //RECOBeaconManager.getInstance(Context, boolean, boolean)의 경우,
    //Context, RECO 비콘만을 대상으로 동작 여부를 설정하는 값, 그리고 백그라운드 monitoring 중 ranging 시 timeout을 설정하는 값을 매개변수로 받습니다

    boolean mScanRecoOnly = true;
    boolean mEnableBackgroundTimeout = true;


    public void bind(){
        RECOBeaconManager recoManager = RECOBeaconManager.getInstance(this, mScanRecoOnly, mEnableBackgroundTimeout);
        recoManager.bind(this);
        //연결 해제시 recoManager.unbind();
        //bind(RECOServiceConnectListener) 메소드 호출 후, RECOBeaconService와 연결되면 RECOServiceConnectListener 클래스의 onServiceConnect() 콜백 메소드가 호출 됩니다.
    }

    @Override
    public void onServiceConnect() {
        //RECOBeaconService와 연결 시 코드 작성
    }

    @Override
    public void onServiceFail(RECOErrorCode recoErrorCode) {
        //RECOBeaconService와 연결 되지 않았을 시 코드 작성
    }
}

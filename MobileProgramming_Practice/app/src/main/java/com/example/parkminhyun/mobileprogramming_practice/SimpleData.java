package com.example.parkminhyun.mobileprogramming_practice;

import android.os.Parcel;
import android.os.Parcelable;

public class SimpleData implements Parcelable{
    int number;
    private String message;


    protected SimpleData(int num, String msg) {
        number = num;
        message = msg;
    }

    protected SimpleData(Parcel in) {
        number = in.readInt();
        message = in.readString();
    }

    public static final Creator<SimpleData> CREATOR = new Creator<SimpleData>() {
        @Override
        public SimpleData createFromParcel(Parcel in) {
            return new SimpleData(in);
        }

        @Override
        public SimpleData[] newArray(int size) {
            return new SimpleData[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(number);
        parcel.writeString(message);


    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
///////////////////Parcelable Data 받기////////////////////////////////////////////////////
//
//    Bundle bundle= getIntent().getExtras();
//    SimpleData data = (SimpleData) bundle.getParcelable(KEY_SIMPLE_DATA);
//        textView.setText("전달받은데이터\nNumber: " + data.getNumber() + "\nMessage: " + data.getMessage());
//
///////////////////////////////////////////////////////////////////////////////////////
//
//    public void onButton1Clicked(View v) {
//        Intent intent = new Intent(this, MenuActivity.class);
//        intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
//        startActivity(intent);
//    }
//
///////////////////////////////////////////////////////////////////////////////////////
//    @Override
//    protected void onStart() {
//        super.onStart();
//        Toast.makeText(this, "onStart호출됨", Toast.LENGTH_SHORT).show();
//    }
//
//    @Override
//    protected void onStop() {
//        super.onStop();
//        Toast.makeText(this, "onStop호출됨", Toast.LENGTH_SHORT).show();
//    }
//
//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        Toast.makeText(this, "onDestroy호출됨", Toast.LENGTH_SHORT).show();
//    }
//
//    @Override
//    protected void onPause() {
//        super.onPause();
//        Toast.makeText(this, "onPause호출됨", Toast.LENGTH_SHORT).show();
//        saveState();// 현재입력상자에입력된데이터를저장
//    }
//
//    @Override
//    protected void onResume() {
//        super.onResume();
//        Toast.makeText(this, "onResume호출됨", Toast.LENGTH_SHORT).show();
//        restoreState();// 설정정보에저장된데이터를복원
//    }
//
///////////////////////////////////////////////////////////////////////////////////////
//    protected void restoreState() {
//        SharedPreferences pref= getSharedPreferences("pref", Activity.MODE_PRIVATE);
//        if ((pref!= null) && (pref.contains("name")) ){
//            String name = pref.getString("name", "");
//            nameInput.setText(name);
//        }
//    }
//
//    protected void saveState() {
//        SharedPreferences pref= getSharedPreferences("pref", Activity.MODE_PRIVATE);
//        SharedPreferences.Editor editor = pref.edit();
//        String A = nameInput.getText().toString();
//        A += "&";
//        A += studentId.getText().toString();
//        A += "&";
//        A += studentName.getText().toString();
//
//        editor.putString("name", A );
//        editor.commit();
//    }
//
//    protected void clearMyPrefs() {
//        SharedPreferences pref= getSharedPreferences("pref", Activity.MODE_PRIVATE);
//        SharedPreferences.Editor editor = pref.edit();
//        editor.clear();
//        editor.commit();
//    }
//
///////////////////////////////////////////////////////////////////////////////////////
//    @Override
//    protected void onNewIntent(Intent intent) {
//        super.onNewIntent(intent);
//    }
//}
///////////////////////////////////////////////////////////////////////////////////////
//    부분 Layout
//    LinearLayout container;
//        container = (LinearLayout)findViewById(R.id.container);
//                LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//                inflater.inflate(R.layout.activity_menu,container,true);


///////////////////////////////////////////////////////////////////////////////////////
//    public static final intREQUEST_CODE_MENU = 101;
//
//    public void onButton1Clicked(View v) {
//
//        Intent intent= new Intent(getApplicationContext(), MenuActivity.class);
//        startActivityForResult(intent, REQUEST_CODE_MENU);// 액티비티띄우기
//    }
//    @Override
//    protected void onActivityResult(intrequestCode, intresultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        if (requestCode== REQUEST_CODE_MENU) {
//            Toast.makeText(getApplicationContext(), "onActivityResult메소드호출됨. 요청코드: " + requestCode+ ", 결과코드: " + resultCode, Toast.LENGTH_LONG).show();
//            if (resultCode== RESULT_OK) {
//                String name = data.getExtras().getString("name");
//                Toast.makeText(getApplicationContext(), "응답으로전달된name : " + name, Toast.LENGTH_LONG).show();
//            }
//        }
//    }
//}
///////////////////////////////////////////////////////////////////////////////////////
//    public void onButton1Clicked(View v) {
//        Intent intent= new Intent(); // 인텐트객체생성하고name의값을부가데이터로넣기
//        intent.putExtra("name", "mike");
//        setResult(RESULT_OK, intent); // 응답보내기
//        finish();// 현재액티비티없애기
//    }
/////////////////////////////////전화하기////////////////////////////////////////////////
//
//    Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:010-1111-2222"));
//    startActivity(intent);
//
//////////////////////////더블클릭///////////////////////////////////////////
//
//    private static final long DOUBLE_PRESS_INTERVAL = 250; // in millis
//    private long lastPressTime;
//
//    private boolean mHasDoubleClicked = false;
//    public boolean onButton1Clicked(View v) {
//        // Get current time in nano seconds.
//        long pressTime = System.currentTimeMillis();
//
//
//        // If double click...
//        if (pressTime - lastPressTime <= DOUBLE_PRESS_INTERVAL) {
//            Toast.makeText(getApplicationContext(), "Double Click Event", Toast.LENGTH_SHORT).show();
//            mHasDoubleClicked = true;
//        } else {     // If not double click....
//            mHasDoubleClicked = false;
//            Handler myHandler = new Handler() {
//                public void handleMessage(Message m) {
//                    if (!mHasDoubleClicked) {
//                        Toast.makeText(getApplicationContext(), "Single Click Event", Toast.LENGTH_SHORT).show();
//                    }
//                }
//            };
//            Message m = new Message();
//            myHandler.sendMessageDelayed(m,DOUBLE_PRESS_INTERVAL);
//        }
//        // record the last time the menu button was pressed.
//        lastPressTime = pressTime;
//        return true;
//    }

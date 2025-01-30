package com.example.covid_19notification;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.app.DatePickerDialog;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import java.io.IOException;
import java.net.URL;
import java.net.URLEncoder;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;


public class MainActivity extends AppCompatActivity {


    Calendar myCalendar = Calendar.getInstance();

    TextView tv_text;
    TextView tv_date;
    TextView tv_decide;
    TextView tv_death;
    TextView tv_decide_total;
    TextView tv_death_total;
    TextView tv_compare_previous_day_cnt;
    TextView tv_compare_previous_day_per;
    TextView tv_compare_previous_week_cnt;
    TextView tv_compare_previous_week_per;
    ImageView imageView;
    ConstraintLayout layout;

    List<DataItem> itemList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_text = (TextView) findViewById(R.id.tv_Text);
        tv_date = (TextView) findViewById(R.id.tv_Date);
        tv_decide = (TextView) findViewById(R.id.tv_Decide_CNT);
        tv_death = (TextView) findViewById(R.id.tv_Death_CNT);
        tv_decide_total = (TextView) findViewById(R.id.tv_Decide_Total);
        tv_death_total = (TextView) findViewById(R.id.tv_Death_Total);
        tv_compare_previous_day_cnt = (TextView) findViewById(R.id.tv_ComparePreviousDay_CNT);
        tv_compare_previous_day_per = (TextView) findViewById(R.id.tv_ComparePreviousDay_PER);
        tv_compare_previous_week_cnt = (TextView) findViewById(R.id.tv_ComparePreviousWeek_CNT);
        tv_compare_previous_week_per = (TextView) findViewById(R.id.tv_ComparePreviousWeek_PER);
        imageView = (ImageView) findViewById(R.id.imageView);
        layout = (ConstraintLayout) findViewById(R.id.layout);

        try {
            init();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

        tv_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(MainActivity.this, myDatePicker, myCalendar.get(Calendar.YEAR), myCalendar.get(Calendar.MONTH), myCalendar.get(Calendar.DAY_OF_MONTH)).show();

            }
        });

    }

    private int getItemIndex(int year, int month, int day) {

        for(int i = 0; i < itemList.size(); i++) {
            DataItem item = itemList.get(i);
            int itemYear = Integer.parseInt(item.getYear());
            int itemMonth = Integer.parseInt(item.getMonth());
            int itemDay = Integer.parseInt(item.getDay());

            if(itemYear < year) {
                return -1;
            }

            if(itemYear == year && itemMonth == month && itemDay == day) {
                return i;
            }
        }
        return -1;
    }

    /**
     * init
     * @throws IOException
     * @throws InterruptedException
     */
    private void init() throws IOException, InterruptedException {
        new GetXMLTask().execute();
    }


    /**
     * Receive dates from users through DatePicker
     */
    DatePickerDialog.OnDateSetListener myDatePicker = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

            myCalendar.set(Calendar.YEAR, year);
            myCalendar.set(Calendar.MONTH, month);
            myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);

            updateDateLabel(year, month + 1, dayOfMonth);
            updateDecideAndDeath(year, month + 1, dayOfMonth);
            updateRemainder(year, month + 1, dayOfMonth);

        }
    };

    /**
     * Update Date Label
     * @param year year
     * @param month month
     * @param day day
     */
    private void updateDateLabel(int year, int month, int day) {
        String time = year + "년 " + month + "월 " + day + "일";
        tv_date.setText(time);
    }

    /**
     * Update Decide_Total and Death_Total
     * @param year year
     * @param month month
     * @param day day
     */
    private void updateDecideAndDeath(int year, int month, int day) {
        int index = getItemIndex(year, month, day);
        if(index != -1) {
            DataItem item = itemList.get(index);
            tv_decide_total.setText(item.getDecideCnt());
            tv_death_total.setText(item.getDeathCnt());
        } else {
            Toast.makeText(getApplicationContext(), "선택한 날짜의 데이터가 존재하지 않습니다.", Toast.LENGTH_SHORT).show();
            tv_text.setText("선택한 날짜의 데이터가 존재하지 않습니다.");
            tv_decide_total.setText("NaN");
            tv_decide.setText("NaN");
            tv_death_total.setText("NaN");
            tv_death.setText("NaN");
        }
    }

    /**
     * Update remainder(Decide, Death, Compared to the previous day, Compared to the previous week)
     * @param year year
     * @param month month
     * @param day day
     */
    private void updateRemainder(int year, int month, int day) {

        List<DataItem> week = new ArrayList<>();
        List<Integer> increaseAmount = new ArrayList<>();

        int currentIndex = getItemIndex(year, month, day);
        if(currentIndex != -1) {
            DataItem item = itemList.get(currentIndex);
            week.add(item);
        } else {
            week.add(null);
        }

        Calendar temporaryCalendar = Calendar.getInstance();
        temporaryCalendar.set(Calendar.YEAR, year);
        temporaryCalendar.set(Calendar.MONTH, month - 1);
        temporaryCalendar.set(Calendar.DAY_OF_MONTH, day);

        for(int i = 0; i < 7; i++) {

            temporaryCalendar.add(Calendar.DAY_OF_MONTH, -1);

            int preYear = temporaryCalendar.get(Calendar.YEAR);
            int preMonth = temporaryCalendar.get(Calendar.MONTH) + 1;
            int preDay = temporaryCalendar.get(Calendar.DAY_OF_MONTH);
            int idx = getItemIndex(preYear, preMonth, preDay);
            if(idx != -1) {
                DataItem item = itemList.get(idx);
                week.add(item);
            } else {
                week.add(null);
            }

        }


        // calculate decide and death
        int decide = -1, death = -1, preDecide = -1;
        DataItem current = week.get(0);
        DataItem previous = week.get(1);
        if(current != null && previous != null) {
            decide = current.getIntDecideCnt() - previous.getIntDecideCnt();
            death = current.getIntDeathCnt() - previous.getIntDeathCnt();
            tv_decide.setText(Integer.toString(decide));
            tv_death.setText(Integer.toString(death));
        } else {
            if(previous == null) {
                Toast.makeText(getApplicationContext(), "선택한 날짜의 전 날 데이터가 존재하지 않습니다.", Toast.LENGTH_SHORT).show();
                tv_text.setText("선택한 날짜의 전 날 데이터가 존재하지 않습니다");
            }
            
            tv_decide.setText("NaN");
            tv_death.setText("NaN");
        }


        // calculate compare previous day
        DataItem previous2 = week.get(2);
        if(previous != null && previous2 != null) {
            preDecide = previous.getIntDecideCnt() - previous2.getIntDecideCnt();
            tv_compare_previous_day_cnt.setText(Integer.toString(preDecide));
        } else {
            if(previous2 == null) {
                Toast.makeText(getApplicationContext(), "선택한 날짜의 전 날 데이터가 올바르지 않습니다.", Toast.LENGTH_SHORT).show();
                tv_text.setText("선택한 날짜의 전 날 데이터가 올바르지 않습니다");
            }
            tv_compare_previous_day_cnt.setText("NaN");
        }
        float preDecidePer = Integer.MIN_VALUE;
        if(decide != -1 && preDecide != -1) {
            preDecidePer = ((float)decide) / ((float)preDecide) * 100 - 100;
            DecimalFormat form = new DecimalFormat("#.##");
            String s = form.format(preDecidePer) + "%";
            tv_compare_previous_day_per.setText(s);
        } else {
            tv_compare_previous_day_per.setText("NaN");
        }


        // calculate the amount of increase and average
        int cnt = 0;
        for(int i = 0; i < 7; i++) {
            DataItem a = itemList.get(i);
            DataItem b = itemList.get(i + 1);
            if(a != null && b != null) {
                int de = a.getIntDecideCnt() - b.getIntDecideCnt();
                increaseAmount.add(de);
            } else {
                increaseAmount.add(-1);
            }
        }
        int sum = 0;
        for(int i = 0; i < 7; i++) {
            int tmp = increaseAmount.get(i);
            if(tmp != -1) {
                sum += tmp;
                cnt++;
            }
        }
        float average = ((float)sum) / ((float)cnt);
        float preWeekDecidePer = Integer.MIN_VALUE;
        DecimalFormat f = new DecimalFormat("#");
        String ss = f.format(average);
        tv_compare_previous_week_cnt.setText(ss);
        if(decide != -1) {
            preWeekDecidePer = ((float)decide / average) * 100 - 100;
            DecimalFormat form = new DecimalFormat("#.##");
            String s = form.format(preWeekDecidePer) + "%";
            tv_compare_previous_week_per.setText(s);
        } else {
            //tv_compare_previous_week_cnt.setText("NaN");
            tv_compare_previous_week_per.setText("NaN");
        }


        // set Image and background color
        if(preWeekDecidePer != Integer.MIN_VALUE && preDecidePer != Integer.MIN_VALUE) {
            if((preWeekDecidePer > -3 && preWeekDecidePer < 3) || (preDecidePer > -5 && preDecidePer < 5)) {
                imageView.setImageResource(R.drawable.default_with_mask_256);
                layout.setBackgroundColor(Color.rgb(255, 255, 255));
                tv_text.setText("평범한 추세, 방심하지 않고 개인 방역에 주의하세요");
            }
            if (preWeekDecidePer <= -3 || preDecidePer <= -5) {
                imageView.setImageResource(R.drawable.smile_with_mask);
                layout.setBackgroundColor(Color.rgb(222, 239, 255));
                tv_text.setText("감소하는 추세, 방심하지 않고 개인 방역에 주의하세요");
            }
            if (preWeekDecidePer >= 3 || preDecidePer >= 5){
                imageView.setImageResource(R.drawable.angry_with_mask_256);
                layout.setBackgroundColor(Color.rgb(255, 222, 222));
                tv_text.setText("증가하는 추세, 방심하지 않고 개인 방역에 주의하세요");
            }
        } else {
            imageView.setImageResource(R.drawable.default_with_mask_256);
            layout.setBackgroundColor(Color.rgb(255, 255, 255));
        }

    }

    /**
     * When this app was first launched, Async Task, which collects data through public API
     * Data is stored in the form of DataItem, and this DataItem is stored in List<DataItem>
     */
    private class GetXMLTask extends AsyncTask<String, Void, Document>{

        @Override
        protected Document doInBackground(String... urls) {

            String myFormat = "yyyyMMdd";
            SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.KOREA);
            String end = sdf.format(myCalendar.getTime());
            String start = "20200120";

            URL url;
            Document doc = null;
            try {
                StringBuilder urlBuilder = new StringBuilder("http://openapi.data.go.kr/openapi/service/rest/Covid19/getCovid19InfStateJson"); /*URL*/
                urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "=[]"); /*Service Key*/
                urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*페이지번호*/
                urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("10", "UTF-8")); /*한 페이지 결과 수*/
                urlBuilder.append("&" + URLEncoder.encode("startCreateDt","UTF-8") + "=" + URLEncoder.encode(start, "UTF-8")); /*검색할 생성일 범위의 시작*/
                urlBuilder.append("&" + URLEncoder.encode("endCreateDt","UTF-8") + "=" + URLEncoder.encode(end, "UTF-8")); /*검색할 생성일 범위의 종료*/
                String s = urlBuilder.toString();

                url = new URL(s);
                DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
                DocumentBuilder db = dbf.newDocumentBuilder();
                doc = db.parse(new InputSource(url.openStream()));
                doc.getDocumentElement().normalize();

            } catch (Exception e) {
                Toast.makeText(getBaseContext(), "Parsing Error", Toast.LENGTH_SHORT).show();
            }
            return doc;
        }

        @Override
        protected void onPostExecute(Document doc) {

            NodeList nodeList = doc.getElementsByTagName("item");

            itemList = new ArrayList<>();

            for(int i = 0; i < nodeList.getLength(); i++) {

                Node node = nodeList.item(i);
                Element fstElmnt = (Element) node;

                NodeList dateTime = fstElmnt.getElementsByTagName("createDt");
                String dtS = dateTime.item(0).getChildNodes().item(0).getNodeValue().substring(0, 10);

                NodeList decide = fstElmnt.getElementsByTagName("decideCnt");
                String dcS = decide.item(0).getChildNodes().item(0).getNodeValue();

                NodeList death = fstElmnt.getElementsByTagName("deathCnt");
                String deS = death.item(0).getChildNodes().item(0).getNodeValue();

                System.out.println(dtS + ", " + dcS + ", " + deS);
                DataItem item = new DataItem(dtS, dcS, deS);

                itemList.add(item);
            }

            DataItem firstItem = itemList.get(0);
            int year = Integer.parseInt(firstItem.getYear());
            int month = Integer.parseInt(firstItem.getMonth());
            int day = Integer.parseInt(firstItem.getDay());

            updateDateLabel(year, month, day);
            updateDecideAndDeath(year, month, day);
            updateRemainder(year, month, day);

            super.onPostExecute(doc);
        }
    }

}
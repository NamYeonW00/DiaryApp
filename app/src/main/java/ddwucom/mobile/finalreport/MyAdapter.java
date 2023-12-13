package ddwucom.mobile.finalreport;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MyAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private ArrayList<MyData> myDataList;
    private LayoutInflater layoutInflater;

    public MyAdapter(Context context, int layout, ArrayList<MyData> myDataList) {
        this.context = context;
        this.layout = layout;
        this.myDataList = myDataList;
        layoutInflater =  (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return myDataList.size();
    }

    @Override
    public Object getItem(int i) {
        return myDataList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return myDataList.get(i).get_id();
    }

    @Override
    public View getView(int pos, View convertView, ViewGroup viewGroup) {
        final int position = pos;
        ViewHolder holder;

        if (convertView == null) {
            convertView = layoutInflater.inflate(layout, viewGroup, false);

            holder = new ViewHolder();

            holder.iv = (ImageView)convertView.findViewById(R.id.iv);
            holder.tvTitle = (TextView)convertView.findViewById(R.id.tvTitle);
            holder.tvPlace = (TextView)convertView.findViewById(R.id.tvPlace);
            holder.tvDate = (TextView)convertView.findViewById(R.id.tvDate);
            convertView.setTag(holder);
        }
        else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.iv.setImageResource(myDataList.get(position).getImg());
        holder.tvTitle.setText(myDataList.get(position).getTitle());
        holder.tvPlace.setText(myDataList.get(position).getPlace());
        holder.tvDate.setText(myDataList.get(position).getDate());
        return convertView;
    }

    static class ViewHolder {
        ImageView iv;
        TextView tvTitle;
        TextView tvPlace;
        TextView tvDate;
    }
}

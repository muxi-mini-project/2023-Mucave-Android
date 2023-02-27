package android.bignerdranch.myapplication.ui.reminder;

import android.bignerdranch.myapplication.R;
import android.bignerdranch.myapplication.ReusableTools.SpaceItemDecoration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ReminderFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private ReminderFragment.Reminder_Adapter mAdapter;

    private class Reminder_Holder extends RecyclerView.ViewHolder{

        private TextView mPersonname;
        private TextView mRemindercontent;
        private TextView mReminderdate;

        private Reminder mReminder;

        public Reminder_Holder(LayoutInflater inflater,ViewGroup parent){
            super(inflater.inflate(R.layout.item_reminder,parent,false));

            mPersonname=(TextView)itemView.findViewById(R.id.reminder_personname);
            mRemindercontent=(TextView)itemView.findViewById(R.id.reminder_content);
            mReminderdate=(TextView)itemView.findViewById(R.id.reminder_date);
        }

        public void bind(Reminder reminder){
            mReminder =reminder;
            mPersonname.setText(mReminder.getPersonName());

            //此处还差通知的具体内容
        }
    }


    private class Reminder_Adapter extends RecyclerView.Adapter<ReminderFragment.Reminder_Holder>{

        private List<Reminder> mReminders;

        public Reminder_Adapter(List<Reminder> reminders){
            mReminders= reminders;
        }

        @Override
        public ReminderFragment.Reminder_Holder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater=LayoutInflater.from(parent.getContext());

            return new ReminderFragment.Reminder_Holder(layoutInflater,parent);
        }

        @Override
        public void onBindViewHolder(ReminderFragment.Reminder_Holder holder, int position) {
            Reminder reminder=mReminders.get(position);
            holder.bind(reminder);
        }

        @Override
        public int getItemCount() {
            return mReminders.size();
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState){
        View view=inflater.inflate(R.layout.layout_reminder,container,false);

        mRecyclerView=(RecyclerView)view.findViewById(R.id.recyclerview_reminder);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        updateUI();

        return view;
    }

    private void updateUI(){
        ReminderLab reminder_lab = ReminderLab.getReminder_lab(getActivity());
        List<Reminder> reminders= reminder_lab.getReminders();

        mRecyclerView.addItemDecoration(new SpaceItemDecoration(20));
        mAdapter=new ReminderFragment.Reminder_Adapter(reminders);
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}
package innovable.dev.warung.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.List;
import innovable.dev.warung.R;
import innovable.dev.warung.models.modelMenu;
public class AdapterListMenu extends RecyclerView.Adapter<AdapterListMenu.MyViewHolder> {

	private Context mContext;
	private List<modelMenu> listhistory;
	public String judul;
	public int id, positioning;
	private final OnItemClickListener listener;
	private final OnItemLongClickListener listener2;

	public class MyViewHolder extends RecyclerView.ViewHolder  {
		public TextView txt_menu, txt_harga;
		public MyViewHolder(View view) {
			super(view);
			txt_menu = (TextView) view.findViewById(R.id.txt_menu);
			txt_harga = (TextView) view.findViewById(R.id.txt_harga);
		}

		public void click(final modelMenu kondisiModel, final OnItemClickListener listener, final OnItemLongClickListener listener2) {
			itemView.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					listener.onClick(kondisiModel);
				}
			});
			itemView.setOnLongClickListener(new View.OnLongClickListener() {
				@Override
				public boolean onLongClick(View view) {
					listener2.onlClick(kondisiModel);
					return false;
				}
			});
		}
	}

	public interface OnItemClickListener {
		void onClick(modelMenu item);
	}
	public interface OnItemLongClickListener {
		void onlClick(modelMenu item);
	}

	public AdapterListMenu(Context mContext, List<modelMenu> models, OnItemClickListener listener, OnItemLongClickListener listener2) {
		this.listhistory=models;
		this.mContext=mContext;
		this.listener = listener;
		this.listener2 = listener2;
	}

	@Override
	public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		View itemView = LayoutInflater.from(parent.getContext())
				.inflate(R.layout.list_menu, parent, false);

		return new MyViewHolder(itemView);
	}

	@Override
	public void onBindViewHolder(final MyViewHolder holder, final int position) {
		final modelMenu album = listhistory.get(position);
		holder.click(listhistory.get(position), listener, listener2);
		holder.txt_menu.setText(album.getItem());
		holder.txt_harga.setText(album.getHarga());
	}

	/**
	 * Showing popup menu when tapping on 3 dots
	 */

	/**
	 * Click listener for popup menu items
	 */
	@Override
	public int getItemCount() {
		return listhistory.size();
	}

}
package com.example.ivan.joilytree.MainTreeRecyclerView.MainTreeDragAndSwipe;

/**
 * Created by Ivan on 11.09.2017.
 */

public interface ItemTouchHelperAdapter {
    void onItemMove(int fromPosition, int toPosition);
    void onItemDismiss(int position);
}

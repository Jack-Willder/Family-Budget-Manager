package com.visuware.family_budget_manager;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.window.SplashScreen;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

        private FloatingActionButton fabAddMember;
        private RecyclerView  memberItems;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_main);

                fabAddMember = findViewById(R.id.fab_add_member);
                fabAddMember.setOnClickListener(v->{
                        showAddItemDialog();
                        Toast.makeText(getApplicationContext(),"Fab clicked", Toast.LENGTH_LONG).show();
                });

//                memberItems = findViewById(R.id.member_items);
//                memberItems.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
//                memberItems.setAdapter();

        }

        private void showAddItemDialog() {

                View dialogView = getLayoutInflater().inflate(R.layout.dialog_add_member, null);

                final EditText editTextDialogItem = dialogView.findViewById(R.id.editTextDialogItem);
                Button buttonAdd = dialogView.findViewById(R.id.buttonAdd);
                Button buttonCancel = dialogView.findViewById(R.id.buttonCancel);

                Context themedContext = new ContextThemeWrapper(this, R.style.TransparentDialog);
                final AlertDialog dialog = new AlertDialog.Builder(themedContext)
                        .setView(dialogView)
                        .create();

                if (dialog.getWindow() != null) {
                        dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
                }

                buttonAdd.setOnClickListener(v -> {
                        String item = editTextDialogItem.getText().toString().trim();
                        if (!item.isEmpty()) {
                                dialog.dismiss();
                        }
                });

                buttonCancel.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                                dialog.dismiss();
                        }
                });

                dialog.show();
        }

}

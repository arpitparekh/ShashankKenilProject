package mridul.rathore.shashankkenilproject.firebase_authentication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import mridul.rathore.shashankkenilproject.databinding.ActivityRegistrationBinding;

public class RegistrationActivity extends AppCompatActivity {

    private ActivityRegistrationBinding binding;

    private FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityRegistrationBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        auth = FirebaseAuth.getInstance();

        binding.btnRegister.setOnClickListener(view -> {

            String email = binding.edtEmailRegister.getText().toString();
            String password = binding.edtPasswordRegister.getText().toString();

            if(!email.isEmpty() && !password.isEmpty()){

                auth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){

                            Toast.makeText(RegistrationActivity.this, "Success", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(RegistrationActivity.this,LoginActivity.class));
                        }
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(RegistrationActivity.this, e.toString(), Toast.LENGTH_SHORT).show();
                    }
                });

            }else{

                if(email.isEmpty()){
                    binding.edtEmailRegister.setError("Fill the Filed");
                }else if(password.isEmpty()){
                    binding.edtPasswordRegister.setError("Fill the Filed");
                }

            }


        });

    }
}
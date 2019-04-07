package com.example.shiva.cureall;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class Main3Activity extends AppCompatActivity {
    DatabaseReference reference;
    Button signIn,register;
    EditText username,email,password;
    SignInButton signInButton;
    FirebaseAuth mAuth;
    GoogleSignInClient mGoogleSignInClient;
    private final static int RC_SIGN_IN=2;
    FirebaseAuth.AuthStateListener mAuthListener;

    @Override
    protected void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        signInButton=findViewById(R.id.google);

        username=findViewById(R.id.editText);
        email=findViewById(R.id.editText2);
        password=findViewById(R.id.editText4);
        register=findViewById(R.id.button);
        mAuth = FirebaseAuth.getInstance();

        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signIn();
            }
        });

        mAuthListener=new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                if(firebaseAuth.getCurrentUser()!=null)
                {
                    startActivity(new Intent(Main3Activity.this,Secondone.class));
                }


            }
        };
        // Configure Google Sign In
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();
        // Build a GoogleSignInClient with the options specified by gso.
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String txt_username=username.getText().toString();
                String txt_email=email.getText().toString();
                String txt_pass=password.getText().toString();

                if(TextUtils.isEmpty(txt_username)|| TextUtils.isEmpty(txt_email) || TextUtils.isEmpty(txt_pass))
                {
                    Toast.makeText(Main3Activity.this,"All fields are required",Toast.LENGTH_SHORT).show();

                }else if(txt_pass.length()<6)
                {
                    Toast.makeText(Main3Activity.this,"password must be at least 6 characters",Toast.LENGTH_SHORT).show();

                }else
                {
                    registeruser(txt_username,txt_email,txt_pass);
                }
            }
        });
    }

    private void registeruser(final String username, final String email, String password)
    {
        ProgressDialog.show(this, "Loading", "Wait while loading...");

        mAuth.createUserWithEmailAndPassword(email,password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful())
                        {
                            FirebaseUser firebaseUser=mAuth.getCurrentUser();
                            //check this also assert
                            assert firebaseUser != null;
                            String uid=firebaseUser.getUid();
                            reference= FirebaseDatabase.getInstance().getReference("Users").child(uid);
                            HashMap<String,String> hashMap=new HashMap<>();
                            hashMap.put("id",uid);
                            hashMap.put("username",username);
                            hashMap.put("email",email);
                            reference.setValue(hashMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if(task.isSuccessful())
                                    {
                                        Toast.makeText(Main3Activity.this,"Successful Register",Toast.LENGTH_SHORT).show();


                                        /*Intent intent=new Intent(Register.this,MainActivity.class);
                                        //check what is flag
                                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK |Intent.FLAG_ACTIVITY_NEW_TASK);
                                        startActivity(intent);
                                        finish();*/
                                    }
                                }
                            });
                        }
                        else
                        {
                            Toast.makeText(Main3Activity.this,"You can't register with this email password",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    private void signIn() {
        ProgressDialog.show(this, "Loading", "Wait while loading...");
        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Result returned from launching the Intent from GoogleSignInApi.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            try {
                // Google Sign In was successful, authenticate with Firebase
                GoogleSignInAccount account = task.getResult(ApiException.class);
                firebaseAuthWithGoogle(account);


            } catch (ApiException e) {
                // Google Sign In failed, update UI appropriately
                Log.i("TAG", "Google sign in failed", e);
                Toast.makeText(Main3Activity.this,"Auth went wrong",Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void firebaseAuthWithGoogle(GoogleSignInAccount account)
    {
        AuthCredential credential = GoogleAuthProvider.getCredential(account.getIdToken(), null);
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d("TAG", "signInWithCredential:success");
                            FirebaseUser user = mAuth.getCurrentUser();

                            //updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.d("TAG", "signInWithCredential:failure", task.getException());
                           /* Snackbar.make(findViewById(R.id.main_layout), "Authentication Failed.", Snackbar.LENGTH_SHORT).show();
                            updateUI(null);*/
                        }

                        // ...
                    }
                });
    }


}

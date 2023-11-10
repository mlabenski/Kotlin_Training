import kotlinx.coroutines.*
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView
import android.view.View

class MainActivity : AppCompatActivity() {
    private lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textView = findViewById(R.id.textView)
    }

    fun onButtonClick(view: View) {
        CoroutineScope(Dispatchers.IO).launch {
            val data = fetchDataFromApi() // This function makes a network request
            withContext(Dispatchers.Main) {
                updateUI(data) // Update the UI with the fetched data
            }
        }
    }

    private suspend fun fetchDataFromApi(): String {
        // Simulate network delay
        delay(2000)
        return "Data retrieved from API"
    }

    private fun updateUI(data: String) {
        textView.text = data
    }
}

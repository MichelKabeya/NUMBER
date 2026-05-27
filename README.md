CODE WHEN USING FUNCTIONS
class MainActivity : AppCompatActivity() {

    private val numbers = IntArray(10)
    private var counter = 0

    lateinit var input: EditText
    lateinit var fullSize: TextView
    lateinit var collect: Button
    lateinit var average: Button

    // FUNCTION TO FILL THE ARRAY
    fun fillArray(value: Int) {
        if (counter < numbers.size) {
            numbers[counter] = value
            counter++
        }
    }

    // FUNCTION TO CALCULATE THE AVERAGE
    fun calculateAverage(): Int {
        var total = 0

        for (i in numbers.indices) {
            total += numbers[i]
        }

        return total / numbers.size
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // LINKING VIEWS
        input = findViewById(R.id.edtInput)
        fullSize = findViewById(R.id.textMsg)
        collect = findViewById(R.id.addBtn)
        average = findViewById(R.id.avgBtn)

        average.visibility = View.INVISIBLE

        // ADD BUTTON
        collect.setOnClickListener {

            if (input.text.toString().isNotEmpty()) {

                val value = input.text.toString().toInt()

                fillArray(value)

                input.text.clear()

                // CHECK IF ARRAY IS FULL
                if (counter >= numbers.size) {
                    fullSize.text = "The array is full"
                    average.visibility = View.VISIBLE
                }
            }
        }

        // AVERAGE BUTTON
        average.setOnClickListener {

            val avg = calculateAverage()

            input.setText(avg.toString())
        }
    }
}

package com.example.footballapp

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3) // Link this activity to the corresponding XML layout file

        // Retrieve the selected team name passed as an extra from MainActivity2 via the Intent
        val teamName = intent.getStringExtra("TEAM_NAME") ?: "Unknown Team" // Use "Unknown Team" as a fallback if no data is received

        // Locate the TextView for displaying the team name in the XML layout
        val teamNameTextView: TextView = findViewById(R.id.teamName)
        // Locate the TextView for displaying the list of players in the XML layout
        val playersListTextView: TextView = findViewById(R.id.playersList)

        // Set the team name TextView to display the selected team name
        teamNameTextView.text = teamName

        // Retrieve the list of players for the selected team using a helper function
        val players = getPlayersForTeam(teamName)
        // Format the players' names as a string with each name on a new line and set it in the playersList TextView
        playersListTextView.text = players.joinToString("\n")
    }

    // Helper function to return a list of players based on the team name
    private fun getPlayersForTeam(teamName: String): List<String> {
        return when (teamName) { // Match the team name to return the corresponding player list
            "Manchester United" -> listOf(
                "Cristiano Ronaldo", // Star forward
                "Marcus Rashford",    // Forward
                "Bruno Fernandes",    // Midfielder
                "Harry Maguire"       // Defender
            )
            "Liverpool" -> listOf(
                "Mohamed Salah",      // Star forward
                "Sadio Mane",         // Forward
                "Virgil van Dijk",    // Defender
                "Trent Alexander-Arnold" // Defender
            )
            "Chelsea" -> listOf(
                "Kai Havertz",        // Forward
                "Mason Mount",        // Midfielder
                "N'Golo Kante",       // Midfielder
                "Thiago Silva"        // Defender
            )
            "Arsenal" -> listOf( // Newly added Arsenal players
                "Saka",
                "Odegaard",
                "Rice",
                "Martinelli"
            )
            "Real Madrid" -> listOf( // Newly added Real Madrid players
                "Vinicius",
                "Mbappe",
                "Modric",
                "Kroos"
            )
            else -> listOf("No players found for this team.") // Fallback for unknown team names
        }
    }
}

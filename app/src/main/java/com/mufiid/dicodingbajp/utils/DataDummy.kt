package com.mufiid.dicodingbajp.utils

import com.mufiid.dicodingbajp.data.MovieEntity
import com.mufiid.dicodingbajp.data.TvShowEntity
import com.mufiid.dicodingbajp.data.source.remote.response.MovieResponse
import com.mufiid.dicodingbajp.data.source.remote.response.TvShowResponse

object DataDummy {

    fun generateDummyMovies(): List<MovieEntity> {

        val movies = ArrayList<MovieEntity>()

        movies.add(
            MovieEntity(
                "m01",
                "Avengers: Infinity War",
                "As the Avengers and their allies have continued to protect the world from threats too large for any one hero to handle, a new danger has emerged from the cosmic shadows: Thanos. A despot of intergalactic infamy, his goal is to collect all six Infinity Stones, artifacts of unimaginable power, and use them to inflict his twisted will on all of reality. Everything the Avengers have fought for has led up to this moment - the fate of Earth and existence itself has never been more uncertain.",
                "April, 25 2018",
                "2h 29m",
                "https://images-na.ssl-images-amazon.com/images/I/81V1KTnYKwL._SL1371_.jpg"
            )
        )
        movies.add(
            MovieEntity(
                "m02",
                "Bird Box",
                "Five years after an ominous unseen presence drives most of society to suicide, a survivor and her two children make a desperate bid to reach safety.",
                "December, 13 2018",
                "2h 4m",
                "https://upload.wikimedia.org/wikipedia/en/b/bd/Bird_Box_%28film%29.png"
            )
        )
        movies.add(
            MovieEntity(
                "m03",
                "Once Upon a Deadpool",
                "A kidnapped Fred Savage is forced to endure Deadpool's PG-13 rendition of Deadpool 2 as a Princess Bride-esque story that's full of magic, wonder &amp; zero F's.",
                "December 11, 2018",
                "1h 57m",
                "https://static.wikia.nocookie.net/xmenmovies/images/0/0e/Once_Upon_a_Deadpool_Poster.jpg/revision/latest/top-crop/width/360/height/360?cb=20181109181202"
            )
        )
        movies.add(
            MovieEntity(
                "m04",
                "Venom",
                "Investigative journalist Eddie Brock attempts a comeback following a scandal, but accidentally becomes the host of Venom, a violent, super powerful alien symbiote. Soon, he must rely on his newfound powers to protect the world from a shadowy organization looking for a symbiote of their own.",
                "September 28, 2018",
                "1h 52m",
                "https://upload.wikimedia.org/wikipedia/en/1/18/Venom_%282018_film_poster%29.png"
            )
        )
        movies.add(
            MovieEntity(
                "m05",
                "Aquaman",
                "nce home to the most advanced civilization on Earth, Atlantis is now an underwater kingdom ruled by the power-hungry King Orm. With a vast army at his disposal, Orm plans to conquer the remaining oceanic people and then the surface world. Standing in his way is Arthur Curry, Orm's half-human, half-Atlantean brother and true heir to the throne.",
                "December 7, 2018",
                "2h 24m",
                "https://m.media-amazon.com/images/M/MV5BOTk5ODg0OTU5M15BMl5BanBnXkFtZTgwMDQ3MDY3NjM@._V1_.jpg"
            )
        )
        movies.add(
            MovieEntity(
                "m06",
                "Spider-Man: Into the Spider-Verse",
                "Miles Morales is juggling his life between being a high school student and being a spider-man. When Wilson \\\"Kingpin\\\" Fisk uses a super collider, others from across the Spider-Verse are transported to this dimension.",
                "December 6, 2018",
                "1h 57m",
                "https://upload.wikimedia.org/wikipedia/id/b/b8/Spider-Man_Into_the_Spider-Verse_%282018_poster%29.png"
            )
        )
        movies.add(
            MovieEntity(
                "m07",
                "A Star Is Born",
                "Seasoned musician Jackson Maine discovers — and falls in love with — struggling artist Ally. She has just about given up on her dream to make it big as a singer — until Jack coaxes her into the spotlight. But even as Ally's career takes off, the personal side of their relationship is breaking down, as Jack fights an ongoing battle with his own internal demons.",
                "October 3, 2018",
                "2h 15m",
                "https://upload.wikimedia.org/wikipedia/en/thumb/3/39/A_Star_is_Born.png/220px-A_Star_is_Born.png"
            )
        )

        movies.add(
            MovieEntity(
                "m08",
                "Glass",
                "In a series of escalating encounters, former security guard David Dunn uses his supernatural abilities to track Kevin Wendell Crumb, a disturbed man who has twenty-four personalities. Meanwhile, the shadowy presence of Elijah Price emerges as an orchestrator who holds secrets critical to both men.",
                "January 16, 2019",
                "2h 9m",
                "https://upload.wikimedia.org/wikipedia/id/0/01/Glass_%282019_poster%29.png"
            )
        )
        movies.add(
            MovieEntity(
                "m09",
                "Retired Thug",
                "After three years, the business of Muslihat (Epi Kusnandar), who has retired as a thug, has a problem. Sales decline. Muslihat also faces new problems when Safira (Safira Maharani), her only daughter, grows up in adolescence and begins to be visited by boys. A bigger problem: frictions between his former subordinates.",
                "January 17, 2019",
                "1h 34m",
                "https://subdl.com/p/sd308/sd308487.jpg"
            )
        )
        movies.add(
            MovieEntity(
                "m10",
                "Creed II",
                "Between personal obligations and training for his next big fight against an opponent with ties to his family's past, Adonis Creed is up against the challenge of his life.",
                "November 21, 2018",
                "2h 10m",
                "https://vicsflickpicks.files.wordpress.com/2018/11/creed.jpg"
            )
        )

        return movies
    }

    fun generateRemoteDummyMovies(): List<MovieResponse> {

        val movies = ArrayList<MovieResponse>()

        movies.add(
            MovieResponse(
                "m01",
                "Avengers: Infinity War",
                "As the Avengers and their allies have continued to protect the world from threats too large for any one hero to handle, a new danger has emerged from the cosmic shadows: Thanos. A despot of intergalactic infamy, his goal is to collect all six Infinity Stones, artifacts of unimaginable power, and use them to inflict his twisted will on all of reality. Everything the Avengers have fought for has led up to this moment - the fate of Earth and existence itself has never been more uncertain.",
                "April, 25 2018",
                "2h 29m",
                "https://images-na.ssl-images-amazon.com/images/I/81V1KTnYKwL._SL1371_.jpg"
            )
        )
        movies.add(
            MovieResponse(
                "m02",
                "Bird Box",
                "Five years after an ominous unseen presence drives most of society to suicide, a survivor and her two children make a desperate bid to reach safety.",
                "December, 13 2018",
                "2h 4m",
                "https://upload.wikimedia.org/wikipedia/en/b/bd/Bird_Box_%28film%29.png"
            )
        )
        movies.add(
            MovieResponse(
                "m03",
                "Once Upon a Deadpool",
                "A kidnapped Fred Savage is forced to endure Deadpool's PG-13 rendition of Deadpool 2 as a Princess Bride-esque story that's full of magic, wonder &amp; zero F's.",
                "December 11, 2018",
                "1h 57m",
                "https://static.wikia.nocookie.net/xmenmovies/images/0/0e/Once_Upon_a_Deadpool_Poster.jpg/revision/latest/top-crop/width/360/height/360?cb=20181109181202"
            )
        )
        movies.add(
            MovieResponse(
                "m04",
                "Venom",
                "Investigative journalist Eddie Brock attempts a comeback following a scandal, but accidentally becomes the host of Venom, a violent, super powerful alien symbiote. Soon, he must rely on his newfound powers to protect the world from a shadowy organization looking for a symbiote of their own.",
                "September 28, 2018",
                "1h 52m",
                "https://upload.wikimedia.org/wikipedia/en/1/18/Venom_%282018_film_poster%29.png"
            )
        )
        movies.add(
            MovieResponse(
                "m05",
                "Aquaman",
                "nce home to the most advanced civilization on Earth, Atlantis is now an underwater kingdom ruled by the power-hungry King Orm. With a vast army at his disposal, Orm plans to conquer the remaining oceanic people and then the surface world. Standing in his way is Arthur Curry, Orm's half-human, half-Atlantean brother and true heir to the throne.",
                "December 7, 2018",
                "2h 24m",
                "https://m.media-amazon.com/images/M/MV5BOTk5ODg0OTU5M15BMl5BanBnXkFtZTgwMDQ3MDY3NjM@._V1_.jpg"
            )
        )
        movies.add(
            MovieResponse(
                "m06",
                "Spider-Man: Into the Spider-Verse",
                "Miles Morales is juggling his life between being a high school student and being a spider-man. When Wilson \\\"Kingpin\\\" Fisk uses a super collider, others from across the Spider-Verse are transported to this dimension.",
                "December 6, 2018",
                "1h 57m",
                "https://upload.wikimedia.org/wikipedia/id/b/b8/Spider-Man_Into_the_Spider-Verse_%282018_poster%29.png"
            )
        )
        movies.add(
            MovieResponse(
                "m07",
                "A Star Is Born",
                "Seasoned musician Jackson Maine discovers — and falls in love with — struggling artist Ally. She has just about given up on her dream to make it big as a singer — until Jack coaxes her into the spotlight. But even as Ally's career takes off, the personal side of their relationship is breaking down, as Jack fights an ongoing battle with his own internal demons.",
                "October 3, 2018",
                "2h 15m",
                "https://upload.wikimedia.org/wikipedia/en/thumb/3/39/A_Star_is_Born.png/220px-A_Star_is_Born.png"
            )
        )

        movies.add(
            MovieResponse(
                "m08",
                "Glass",
                "In a series of escalating encounters, former security guard David Dunn uses his supernatural abilities to track Kevin Wendell Crumb, a disturbed man who has twenty-four personalities. Meanwhile, the shadowy presence of Elijah Price emerges as an orchestrator who holds secrets critical to both men.",
                "January 16, 2019",
                "2h 9m",
                "https://upload.wikimedia.org/wikipedia/id/0/01/Glass_%282019_poster%29.png"
            )
        )
        movies.add(
            MovieResponse(
                "m09",
                "Retired Thug",
                "After three years, the business of Muslihat (Epi Kusnandar), who has retired as a thug, has a problem. Sales decline. Muslihat also faces new problems when Safira (Safira Maharani), her only daughter, grows up in adolescence and begins to be visited by boys. A bigger problem: frictions between his former subordinates.",
                "January 17, 2019",
                "1h 34m",
                "https://subdl.com/p/sd308/sd308487.jpg"
            )
        )
        movies.add(
            MovieResponse(
                "m10",
                "Creed II",
                "Between personal obligations and training for his next big fight against an opponent with ties to his family's past, Adonis Creed is up against the challenge of his life.",
                "November 21, 2018",
                "2h 10m",
                "https://vicsflickpicks.files.wordpress.com/2018/11/creed.jpg"
            )
        )

        return movies
    }

    fun generateDummyTvShow(): List<TvShowEntity> {

        val tvShow = ArrayList<TvShowEntity>()

        tvShow.add(
            TvShowEntity(
                "tv01",
                "The Simpson",
                "Set in Springfield, the average American town, the show focuses on the antics and everyday adventures of the Simpson family; Homer, Marge, Bart, Lisa and Maggie, as well as a virtual cast of thousands. Since the beginning, the series has been a pop culture icon, attracting hundreds of celebrities to guest star. The show has also made name for itself in its fearless satirical take on politics, media and American life in general.",
                "December 17, 1989",
                "22m",
                "https://cdn1-production-images-kly.akamaized.net/CcWtc8ylWoPZt9dSzP1toN2vYwI=/640x853/smart/filters:quality(75):strip_icc():format(jpeg)/kly-media-production/medias/2981131/original/075971800_1574998494-the_simpsons.jpg"
            )
        )
        tvShow.add(
            TvShowEntity(
                "tv02",
                "Hanna",
                "This thriller and coming-of-age drama follows the journey of an extraordinary young girl as she evades the relentless pursuit of an off-book CIA agent and tries to unearth the truth behind who she is. Based on the 2011 Joe Wright film.",
                "March 28, 2019",
                "50m",
                "https://resizing.flixster.com/eZzB3h3WEckGUIUmDoCGcA7q6v0=/206x305/v1.dDs0NDc0MjE7ajsxODYzNTsxMjAwOzQwNDs2MDg"
            )
        )
        tvShow.add(
            TvShowEntity(
                "tv03",
                "Riverdale",
                "Set in the present, the series offers a bold, subversive take on Archie, Betty, Veronica and their friends, exploring the surreality of small-town life, the darkness and weirdness bubbling beneath Riverdale's wholesome facade.",
                "January 26, 2017",
                "45m",
                "https://whstoday.com/wp-content/uploads/2017/09/riverdale.jpg"
            )
        )
        tvShow.add(
            TvShowEntity(
                "tv04",
                "Dragon Ball",
                "Long ago in the mountains, a fighting master known as Gohan discovered a strange boy whom he named Goku. Gohan raised him and trained Goku in martial arts until he died. The young and very strong boy was on his own, but easily managed. Then one day, Goku met a teenage girl named Bulma, whose search for the dragon balls brought her to Goku's home. Together, they set off to find all seven dragon balls in an adventure.",
                "February, 26 1986",
                "25m",
                "https://m.media-amazon.com/images/M/MV5BNDYyNTJkNmItYjgxNC00ODliLTg2MGMtZjkxNjEwYzdjNjUxXkEyXkFqcGdeQXVyNTA4NzY1MzY@._V1_.jpg"
            )
        )
        tvShow.add(
            TvShowEntity(
                "tv05",
                "Shameless",
                "hicagoan Frank Gallagher is the proud single dad of six smart, industrious, independent kids, who without him would be&#8230; perhaps better off. When Frank's not at the bar spending what little money they have, he's passed out on the floor. But the kids have found ways to grow up in spite of him. They may not be like any family you know, but they make no apologies for being exactly who they are.",
                "January 9, 2009",
                "60m",
                "https://i.pinimg.com/originals/f1/dd/93/f1dd93bb8806a9e77c6c0460aa99a98b.jpg"
            )
        )
        tvShow.add(
            TvShowEntity(
                "tv06",
                "Naruto Shippūden",
                "Naruto Shippuuden is the continuation of the original animated TV series Naruto.The story revolves around an older and slightly more matured Uzumaki Naruto and his quest to save his friend Uchiha Sasuke from the grips of the snake-like Shinobi, Orochimaru. After 2 and a half years Naruto finally returns to his village of Konoha, and sets about putting his ambitions to work, though it will not be easy, as He has amassed a few (more dangerous) enemies, in the likes of the shinobi organization; Akatsuki.",
                "February 15, 2007",
                "22m",
                "https://img.sharetv.com/shows/standard/naruto_shippuuden_jp.jpg"
            )
        )
        tvShow.add(
            TvShowEntity(
                "tv07",
                "Family Guy",
                "Sick, twisted, politically incorrect and Freakin' Sweet animated series featuring the adventures of the dysfunctional Griffin family. Bumbling Peter and long-suffering Lois have three kids. Stewie (a brilliant but sadistic baby bent on killing his mother and taking over the world), Meg (the oldest, and is the most unpopular girl in town) and Chris (the middle kid, he's not very bright but has a passion for tvShows). The final member of the family is Brian - a talking dog and much more than a pet, he keeps Stewie in check whilst sipping Martinis and sorting through his own life issues.",
                "January 31, 1999",
                "22m",
                "https://m.media-amazon.com/images/M/MV5BODEwZjEzMjAtNjQxMy00Yjc4LWFlMDAtYjhjZTAxNDU3OTg3XkEyXkFqcGdeQXVyOTM2NTM4MjA@._V1_UY268_CR9,0,182,268_AL_.jpg"
            )
        )

        tvShow.add(
            TvShowEntity(
                "tv08",
                "Supergirl",
                "Twenty-four-year-old Kara Zor-El, who was taken in by the Danvers family when she was 13 after being sent away from Krypton, must learn to embrace her powers after previously hiding them. The Danvers teach her to be careful with her powers, until she has to reveal them during an unexpected disaster, setting her on her journey of heroism.",
                "October 26, 2015",
                "44m",
                "https://static.wikia.nocookie.net/marvel_dc/images/a/af/Supergirl_TV_Series_0001.jpg/revision/latest?cb=20151026233604"
            )
        )
        tvShow.add(
            TvShowEntity(
                "tv09",
                "The Flash",
                "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only \"meta-human\" who was created in the wake of the accelerator explosion &#8212; and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won't be long before the world learns what Barry Allen has become&#8230;The Flash.",
                "October 7, 2014",
                "44m",
                "https://upload.wikimedia.org/wikipedia/en/2/2e/The_Flash_season_6.jpg"
            )
        )
        tvShow.add(
            TvShowEntity(
                "tv10",
                "Fairy Tail",
                "Lucy is a 17-year-old girl, who wants to be a full-fledged mage. One day when visiting Harujion Town, she meets Natsu, a young man who gets sick easily by any type of transportation. But Natsu isn't just any ordinary kid, he's a member of one of the world's most infamous mage guilds: Fairy Tail.",
                "October 12, 2009",
                "25m",
                "https://cdn.myanimelist.net/images/anime/1536/93863.jpg"
            )
        )

        return tvShow
    }

    fun generateRemoteDummyTvShow(): List<TvShowResponse> {

        val tvShow = ArrayList<TvShowResponse>()

        tvShow.add(
            TvShowResponse(
                "tv01",
                "The Simpson",
                "Set in Springfield, the average American town, the show focuses on the antics and everyday adventures of the Simpson family; Homer, Marge, Bart, Lisa and Maggie, as well as a virtual cast of thousands. Since the beginning, the series has been a pop culture icon, attracting hundreds of celebrities to guest star. The show has also made name for itself in its fearless satirical take on politics, media and American life in general.",
                "December 17, 1989",
                "22m",
                "https://cdn1-production-images-kly.akamaized.net/CcWtc8ylWoPZt9dSzP1toN2vYwI=/640x853/smart/filters:quality(75):strip_icc():format(jpeg)/kly-media-production/medias/2981131/original/075971800_1574998494-the_simpsons.jpg"
            )
        )
        tvShow.add(
            TvShowResponse(
                "tv02",
                "Hanna",
                "This thriller and coming-of-age drama follows the journey of an extraordinary young girl as she evades the relentless pursuit of an off-book CIA agent and tries to unearth the truth behind who she is. Based on the 2011 Joe Wright film.",
                "March 28, 2019",
                "50m",
                "https://resizing.flixster.com/eZzB3h3WEckGUIUmDoCGcA7q6v0=/206x305/v1.dDs0NDc0MjE7ajsxODYzNTsxMjAwOzQwNDs2MDg"
            )
        )
        tvShow.add(
            TvShowResponse(
                "tv03",
                "Riverdale",
                "Set in the present, the series offers a bold, subversive take on Archie, Betty, Veronica and their friends, exploring the surreality of small-town life, the darkness and weirdness bubbling beneath Riverdale's wholesome facade.",
                "January 26, 2017",
                "45m",
                "https://whstoday.com/wp-content/uploads/2017/09/riverdale.jpg"
            )
        )
        tvShow.add(
            TvShowResponse(
                "tv04",
                "Dragon Ball",
                "Long ago in the mountains, a fighting master known as Gohan discovered a strange boy whom he named Goku. Gohan raised him and trained Goku in martial arts until he died. The young and very strong boy was on his own, but easily managed. Then one day, Goku met a teenage girl named Bulma, whose search for the dragon balls brought her to Goku's home. Together, they set off to find all seven dragon balls in an adventure.",
                "February, 26 1986",
                "25m",
                "https://m.media-amazon.com/images/M/MV5BNDYyNTJkNmItYjgxNC00ODliLTg2MGMtZjkxNjEwYzdjNjUxXkEyXkFqcGdeQXVyNTA4NzY1MzY@._V1_.jpg"
            )
        )
        tvShow.add(
            TvShowResponse(
                "tv05",
                "Shameless",
                "hicagoan Frank Gallagher is the proud single dad of six smart, industrious, independent kids, who without him would be&#8230; perhaps better off. When Frank's not at the bar spending what little money they have, he's passed out on the floor. But the kids have found ways to grow up in spite of him. They may not be like any family you know, but they make no apologies for being exactly who they are.",
                "January 9, 2009",
                "60m",
                "https://i.pinimg.com/originals/f1/dd/93/f1dd93bb8806a9e77c6c0460aa99a98b.jpg"
            )
        )
        tvShow.add(
            TvShowResponse(
                "tv06",
                "Naruto Shippūden",
                "Naruto Shippuuden is the continuation of the original animated TV series Naruto.The story revolves around an older and slightly more matured Uzumaki Naruto and his quest to save his friend Uchiha Sasuke from the grips of the snake-like Shinobi, Orochimaru. After 2 and a half years Naruto finally returns to his village of Konoha, and sets about putting his ambitions to work, though it will not be easy, as He has amassed a few (more dangerous) enemies, in the likes of the shinobi organization; Akatsuki.",
                "February 15, 2007",
                "22m",
                "https://img.sharetv.com/shows/standard/naruto_shippuuden_jp.jpg"
            )
        )
        tvShow.add(
            TvShowResponse(
                "tv07",
                "Family Guy",
                "Sick, twisted, politically incorrect and Freakin' Sweet animated series featuring the adventures of the dysfunctional Griffin family. Bumbling Peter and long-suffering Lois have three kids. Stewie (a brilliant but sadistic baby bent on killing his mother and taking over the world), Meg (the oldest, and is the most unpopular girl in town) and Chris (the middle kid, he's not very bright but has a passion for tvShows). The final member of the family is Brian - a talking dog and much more than a pet, he keeps Stewie in check whilst sipping Martinis and sorting through his own life issues.",
                "January 31, 1999",
                "22m",
                "https://m.media-amazon.com/images/M/MV5BODEwZjEzMjAtNjQxMy00Yjc4LWFlMDAtYjhjZTAxNDU3OTg3XkEyXkFqcGdeQXVyOTM2NTM4MjA@._V1_UY268_CR9,0,182,268_AL_.jpg"
            )
        )

        tvShow.add(
            TvShowResponse(
                "tv08",
                "Supergirl",
                "Twenty-four-year-old Kara Zor-El, who was taken in by the Danvers family when she was 13 after being sent away from Krypton, must learn to embrace her powers after previously hiding them. The Danvers teach her to be careful with her powers, until she has to reveal them during an unexpected disaster, setting her on her journey of heroism.",
                "October 26, 2015",
                "44m",
                "https://static.wikia.nocookie.net/marvel_dc/images/a/af/Supergirl_TV_Series_0001.jpg/revision/latest?cb=20151026233604"
            )
        )
        tvShow.add(
            TvShowResponse(
                "tv09",
                "The Flash",
                "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only \"meta-human\" who was created in the wake of the accelerator explosion &#8212; and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won't be long before the world learns what Barry Allen has become&#8230;The Flash.",
                "October 7, 2014",
                "44m",
                "https://upload.wikimedia.org/wikipedia/en/2/2e/The_Flash_season_6.jpg"
            )
        )
        tvShow.add(
            TvShowResponse(
                "tv10",
                "Fairy Tail",
                "Lucy is a 17-year-old girl, who wants to be a full-fledged mage. One day when visiting Harujion Town, she meets Natsu, a young man who gets sick easily by any type of transportation. But Natsu isn't just any ordinary kid, he's a member of one of the world's most infamous mage guilds: Fairy Tail.",
                "October 12, 2009",
                "25m",
                "https://cdn.myanimelist.net/images/anime/1536/93863.jpg"
            )
        )

        return tvShow
    }
}
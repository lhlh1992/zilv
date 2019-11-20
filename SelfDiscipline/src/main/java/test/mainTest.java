//package test;
//
//import java.io.BufferedReader;
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.Scanner;
//import java.util.StringTokenizer;
//
//public class mainTest {
//											
//    // 在平台申请的APP_ID 详见 http://api.fanyi.baidu.com/api/trans/product/desktop?req=developer
//    private static final String APP_ID = "20190831000330794";
//    private static final String SECURITY_KEY = "mIOtSDqaxuA7L19jaX3k";
//
//    public static void main(String[] args) {
//        TransApi api = new TransApi(APP_ID, SECURITY_KEY);
//
//        String query = " <article role=\"article\">\r\n" + 
//        		"      <p>BEVERLY KIRK: (In progress) – Initiative here at CSIS. And thank you so much for joining us tonight, both here\r\n" + 
//        		"        in the room and online.</p>\r\n" + 
//        		"      <p>We are absolutely honored and delighted to welcome NASA Astronaut Dr. Jeanette Epps for what is sure to be a\r\n" + 
//        		"        fabulous conversation about international collaboration in human spaceflight and her training experiences in\r\n" + 
//        		"        Russia, Germany, and Japan, among other places. If you look off to the screen over here to my right, your left,\r\n" + 
//        		"        you’ll be able to see a rolling – a scrolling number of photos of her as she was doing her training in\r\n" + 
//        		"        preparation for becoming an astronaut.</p>\r\n" + 
//        		"      <p>First, a few social media reminders. Be sure to follow us on Twitter; we’re @SmartWomen. And be sure to check\r\n" + 
//        		"        out our Smart Women podcast on iTunes and now on Spotify. If you’re live tweeting tonight, and we certainly hope\r\n" + 
//        		"        that you are, please throw in the hashtag #CSISLive. Tonight’s event is presented jointly with the CSIS\r\n" + 
//        		"        Aerospace Security Project. And be sure to follow them on Twitter @CSISAerospace. And if you’re watching online,\r\n" + 
//        		"        you can submit questions tonight through the aerospace.csis.org website, and just add /questions and you’ll be\r\n" + 
//        		"        able to submit a question here for Dr. Epps.</p>\r\n" + 
//        		"      <p>Now, if a fire alarm or anything should go off here in the room tonight, follow my instructions, and we’ll\r\n" + 
//        		"        leave out of the front of the building and meet up over at National Geographic. Our Smart Women, Smart Power –\r\n" + 
//        		"        (laughter) – but of course nothing’s going to happen, so you don’t need to worry about that.</p>\r\n" + 
//        		"      <p>Our Smart Women, Smart Power Series would not be possible without the fabulous support of Citi. Thank you very\r\n" + 
//        		"        much for helping us amplify the voices of women who are in foreign policy, national security, and international\r\n" + 
//        		"        business and development.</p>\r\n" + 
//        		"      <p>Please welcome to the stage Kristin Solheim. She is director of federal government affairs at Citi. Kristin?\r\n" + 
//        		"      </p>\r\n" + 
//        		"      <p>KRISTIN SOLHEIM: Thanks, Bev. It’s great to be here. Thanks for – thanks for taking time to be with us tonight\r\n" + 
//        		"        for another great edition of Smart Women, Smart Power.</p>\r\n" + 
//        		"      <p>Citi’s proud to sponsor these events that bring together women leaders in foreign policy, national security,\r\n" + 
//        		"        and the business community to convene a dialogue covering just a wealth of topics. At Citi we’re present in more\r\n" + 
//        		"        than a hundred countries, and our unique global footprint offers a diverse perspective on challenges and\r\n" + 
//        		"        opportunities in myriad economic and political climates all around the world and in the United States. We can\r\n" + 
//        		"        confront these challenges daily in our mission to provide financial services that enable growth and economic\r\n" + 
//        		"        progress.</p>\r\n" + 
//        		"      <p>While Citi has a presence in almost – almost everywhere around the world and we usually try to make a\r\n" + 
//        		"        connection to our speaker’s region of expertise, I must confess it was a little harder with an astronaut. We\r\n" + 
//        		"        don’t have any branches in space just yet. (Laughter.)</p>\r\n" + 
//        		"      <p>But Dr. Epps certainly embodies everything that the Smart Power – Smart Series stands for, and we couldn’t be\r\n" + 
//        		"        more excited to hear about your journey and your fascinating career. So thanks for being with us, and back to\r\n" + 
//        		"        you.</p>\r\n" + 
//        		"      <p>MS. KIRK: Thank you, Kristin.</p>\r\n" + 
//        		"      <p>And I want to bring up Todd Harrison. He’s a senior fellow and director of the CSIS Aerospace Security Project,\r\n" + 
//        		"        and he’s going to introduce our guest. Todd?</p>\r\n" + 
//        		"      <p>TODD HARRISON: Thank you, Bev.</p>\r\n" + 
//        		"      <p>And it’s my real pleasure here to introduce our featured guest this evening, Dr. Jeanette Epps. Dr. Epps was\r\n" + 
//        		"        selected as part of NASA’s 20 <sup>th</sup> astronaut class in 2009. She currently serves in the International\r\n" + 
//        		"        Space Station Operations Branch in Houston and works on issues in support of space station crews.</p>\r\n" + 
//        		"      <p>Dr. Epps earned her Ph.D. in aerospace engineering from the University of Maryland in 2000. And following\r\n" + 
//        		"        graduate school, she spent two years working at Ford Motor Company. Dr. Epps then spent the next seven years at\r\n" + 
//        		"        the CIA as a technical intelligence officer. And I tried to find any details on what she did while at the CIA –\r\n" + 
//        		"        (laughter) – and I came up short. I guess that’s by design.</p>\r\n" + 
//        		"      <p>And it’s also my pleasure to introduce our moderator for the evening, CSIS Senior Associate Nina Easton, who is\r\n" + 
//        		"        also chair of Fortune’s Most Powerful Women International Summit and the co-chair of the Fortune Global Forum.\r\n" + 
//        		"      </p>\r\n" + 
//        		"      <p>So, again, thank you all for joining us this evening. We like to think of this as Smart Women in Space, an\r\n" + 
//        		"        offshoot of Smart Women. But, again, thank you all for joining us, and please join me in welcoming Dr. Epps and\r\n" + 
//        		"        Nina Easton. (Applause.)</p>\r\n" + 
//        		"      <p>NINA EASTON: So thank you all for being here. You know, this is a – we know this is the Smart Women, Smart\r\n" + 
//        		"        Power Series, but today we’re going to have a little bit of also an offshoot of that: Smart Girls, Smart Power.\r\n" + 
//        		"        We’ve got fifth graders from Stone Ridge right here, including my daughter. And that’s all by way of saying\r\n" + 
//        		"        we’re going to be talking about high-level stuff; a few times I’ll go a little bit more on their level because\r\n" + 
//        		"        we really are – in this program we’re all about inspiring women and girls to do their best, to take tough career\r\n" + 
//        		"        paths, especially in science and national security and global issues.</p>\r\n" + 
//        		"      <p>So thank you so much for being here.</p>\r\n" + 
//        		"      <p>JEANETTE J. EPPS: Oh, it’s my pleasure, definitely.</p>\r\n" + 
//        		"      <p>MS. EASTON: May I call you Jeanette?</p>\r\n" + 
//        		"      <p>MS. EPPS: Of course. Of course, yes.</p>\r\n" + 
//        		"      <p>MS. EASTON: OK, Jeanette. Here we go.</p>\r\n" + 
//        		"      <p>So you grew up in Syracuse, New York, and you were one of seven children –</p>\r\n" + 
//        		"      <p>MS. EPPS: Yes.</p>\r\n" + 
//        		"      <p>MS. EASTON: – with a divorced mom.</p>\r\n" + 
//        		"      <p>MS. EPPS: Yes.</p>\r\n" + 
//        		"      <p>MS. EASTON: She did it all by herself. How was that?</p>\r\n" + 
//        		"      <p>MS. EPPS: Well, I mean, as it sounds, it was tough. But she was fortunate that Janet and I – I have a twin\r\n" + 
//        		"        sister, Janet, and she –</p>\r\n" + 
//        		"      <p>MS. EASTON: Who does not look like her.</p>\r\n" + 
//        		"      <p>MS. EPPS: No. We’re fraternal twins.</p>\r\n" + 
//        		"      <p>MS. EASTON: We established that. You’re fraternal.</p>\r\n" + 
//        		"      <p>MS. EPPS: And we were – we were pretty obedient, partly because we saw what happened to our older brothers and\r\n" + 
//        		"        sisters when they didn’t bring home good grades and, you know, when they misbehaved. So my mom really kind of\r\n" + 
//        		"        poured herself into Janet and I, being the last two kids, and she encouraged everything we wanted to do. She was\r\n" + 
//        		"        a high school graduate and that was it. She really didn’t understand what Janet and I wanted to do. We were kind\r\n" + 
//        		"        of oddballs to her, but she never said we couldn’t do what we wanted to do.</p>\r\n" + 
//        		"      <p>MS. EASTON: How were you oddballs, just because you were so studious, or?</p>\r\n" + 
//        		"      <p>MS. EPPS: We were studious, but I wanted to be an engineer. You know, I remember being a kid and saying, well,\r\n" + 
//        		"        you know, I’ll become an aerospace engineer. She’s like – she did not know what that was. I didn’t know either\r\n" + 
//        		"        at nine years old. But she said –</p>\r\n" + 
//        		"      <p>MS. EASTON: Sounded good.</p>\r\n" + 
//        		"      <p>MS. EPPS: Sounded great. And she’s like, OK.</p>\r\n" + 
//        		"      <p>And Janet went into chemistry and molecular cell biology. And, you know, my mom said, OK, great, and we’ll get\r\n" + 
//        		"        there. She didn’t quite know how we’d get there, but –</p>\r\n" + 
//        		"      <p>MS. EASTON: That is so impressive.</p>\r\n" + 
//        		"      <p>MS. EPPS: Well, we had a community that really helped out. You know, my undergrad was a great school. They\r\n" + 
//        		"        really supported Janet and I, and we, you know, graduated from there in four years and then ended up going to\r\n" + 
//        		"        the University of Maryland. So we had a great community in Syracuse that really helped us get through.</p>\r\n" + 
//        		"      <p>MS. EASTON: So let’s talk about your interest in space. It also began as a young girl, nine-ish, I believe,\r\n" + 
//        		"        like these girls sitting right here.</p>\r\n" + 
//        		"      <p>MS. EPPS: Exactly.</p>\r\n" + 
//        		"      <p>MS. EASTON: You know, when I was that – I’m a little older, so when I – when I was that age, it was the time\r\n" + 
//        		"        when we had men – male astronauts on the Moon. They were arriving on the Moon; 12 astronauts between 1969 and\r\n" + 
//        		"        1972, I believe it was, actually walked on the Moon. In your era, wasn’t Sally Ride kind of coming along right\r\n" + 
//        		"        about then, first woman astronaut?</p>\r\n" + 
//        		"      <p>MS. EPPS: It was.</p>\r\n" + 
//        		"      <p>MS. EASTON: Sort of tell us about your interest in space and how she figured into it.</p>\r\n" + 
//        		"      <p>MS. EPPS: Well, it was weird because I really didn’t have a lot of knowledge about space. And what happened was\r\n" + 
//        		"        my brother came home from college and, you know, my twin sister and I, we were a little – we wanted to make sure\r\n" + 
//        		"        he knew that we got really good grades in school. And so he looked at our report cards and he said, wow, this is\r\n" + 
//        		"        great; you know, maybe you can become an astronaut or, you know, maybe an aerospace engineer or something. And,\r\n" + 
//        		"        you know, Janet didn’t want to become an engineer or anything like that. And I was the one that said, well, you\r\n" + 
//        		"        know, they’ll probably never pick me for an astronaut, but I can definitely become an aerospace engineer. And so\r\n" + 
//        		"        that’s kind of how this whole thing got started.</p>\r\n" + 
//        		"      <p>But even then, you know, in aerospace you start thinking about all these things that you see in the sky. You\r\n" + 
//        		"        know, you see the stars. You see the planes. You see all these different things flying. And aerospace is so\r\n" + 
//        		"        comprehensive. There are so many things: helicopters, there’s UAVs now, there’s airplanes, there’s shuttles,\r\n" + 
//        		"        there’s rockets. And so aerospace started to really interest me at that age, so.</p>\r\n" + 
//        		"      <p>MS. EASTON: But what about it? Was it the how to make things fly? Or was it space itself?</p>\r\n" + 
//        		"      <p>MS. EPPS: I think with most girls and most boys there’s a curiosity about, well, how does that work? It looks\r\n" + 
//        		"        so interesting. Well, how does that work? And how can I work on that? How can I make it better? How can I\r\n" + 
//        		"        improve that? How can I be involved in that? And I think as a 9-year-old, just thinking of how I can contribute\r\n" + 
//        		"        and be a part of that was the big thing for me.</p>\r\n" + 
//        		"      <p>Because Janet and I, we were doing things like – we were doing well in mathematics, so we really didn’t have an\r\n" + 
//        		"        idea of what engineering would be. And Janet really didn’t know, OK, chemistry, biology; you know, she started\r\n" + 
//        		"        looking at plants and things like that, and so it kind of snowballed into going into molecular cell biology. And\r\n" + 
//        		"        so I think it was more of just a curiosity.</p>\r\n" + 
//        		"      <p>And I think girls – like, I even see it in my 8-year-old niece. There’s a certain amount of curiosity that they\r\n" + 
//        		"        want to know everything and they just want to figure it out. And I –</p>\r\n" + 
//        		"      <p>MS. EASTON: So that’s a good thing and they should pull on that string.</p>\r\n" + 
//        		"      <p>MS. EPPS: Oh, definitely. And I think starting at – it really does start around the age of nine, when you start\r\n" + 
//        		"        planting those seeds in their brain of, you know, well, you know you can become this, or you may want to look\r\n" + 
//        		"        into this, or you may want to think about that. And I do know, like, my brother saying those words to me stuck\r\n" + 
//        		"        with me all those years.</p>\r\n" + 
//        		"      <p>And so when I went to undergrad, I had to go into physics because I went to a small Jesuit school. But then I\r\n" + 
//        		"        left there in four years and I said, no, I’m definitely going into aerospace. And I – and it just stuck with me\r\n" + 
//        		"        from – you know, I couldn’t shake it. So no matter what I did – I even tried to do an internship in pathology\r\n" + 
//        		"        when I was in – at LeMoyne College. And, you know, one of the professors there, one of the doctors, he was doing\r\n" + 
//        		"        autopsies. I was 17 at the time, and he invited me in to kind of watch one of these. And so I watched the\r\n" + 
//        		"        autopsy, and after I came out of there I was definitely sure that I was going into engineering and not\r\n" + 
//        		"        pathology, none of that. (Laughter.) I didn’t want any part of it.</p>\r\n" + 
//        		"      <p>MS. EASTON: So can you explain, like, what it is about engineering that you love?</p>\r\n" + 
//        		"      <p>MS. EPPS: OK. So there’s so many cool things about engineering. First, you get to solve problems. You get to\r\n" + 
//        		"        create things. You get to see the end product of – like, if you design an airplane and then you see it fly, that\r\n" + 
//        		"        is – to me is gratifying because you were a part of that and you contributed to making it better. Like, even\r\n" + 
//        		"        working at Ford Motor Company when we were designing different actuators to reduce vibrations into the car. And\r\n" + 
//        		"        the experiments that we did mounting these actuators on the arm – the control arm and then seeing it actually\r\n" + 
//        		"        work, that you actually reduced the vibrations in the car. And so, to me, creating and making things better is\r\n" + 
//        		"        what I enjoy a lot.</p>\r\n" + 
//        		"      <p>MS. EASTON: So then you took this aeronautical engineering degree into the CIA, and as we just learned you\r\n" + 
//        		"        haven’t been very open about what exactly you did in Iraq – (laughter) – but I’m going to try. (Laughs.) What\r\n" + 
//        		"        did you do?</p>\r\n" + 
//        		"      <p>MS. EPPS: Well, so I think – (laughter) – well, I think everything is kind of a complete story in the sense\r\n" + 
//        		"        that, you know, working at Ford Motor Company and even going through graduate school as a scientist, you work so\r\n" + 
//        		"        hard in a lab and you’re doing those things, your kind of head’s down. And so I never thought that, you know, I\r\n" + 
//        		"        would ever be selected as an astronaut, even though in graduate school I had so many friends applying. I even\r\n" + 
//        		"        had one friend who actually did get in.</p>\r\n" + 
//        		"      <p>But then going to the CIA you kind of learn that there is another side to being a scientist, and it’s an\r\n" + 
//        		"        operational side. And I think that’s what an astronaut is all about. You’re very technical, but then when you go\r\n" + 
//        		"        into space you are the hands and the eyes of every scientist that has a project onboard the space station, and\r\n" + 
//        		"        so you’re more operational. But the operational aspect also comes from just getting to the space station and\r\n" + 
//        		"        flying on the Soyuz and all the things that you have to learn in order to get there.</p>\r\n" + 
//        		"      <p>MS. EASTON: So she’s very good at not answering it once again. (Laughter.) You’re a good CIA agent. (Laughter.)\r\n" + 
//        		"        It’s OK.</p>\r\n" + 
//        		"      <p>MS. EPPS: So everything is about being a scientist and solving problems.</p>\r\n" + 
//        		"      <p>MS. EASTON: OK.</p>\r\n" + 
//        		"      <p>MS. EPPS: Yes. (Laughs.)</p>\r\n" + 
//        		"      <p>MS. EASTON: So then you – let’s move on to NASA. And by the way, this is – our great think tank here offered up\r\n" + 
//        		"        some numbers. There are 500 astronauts worldwide. Of them, 50 are women, and most of them are American. And so\r\n" + 
//        		"        that’s kind of an interesting number. And you were chosen. Tell us about being chosen to become an astronaut.\r\n" + 
//        		"      </p>\r\n" + 
//        		"      <p>MS. EPPS: Well, it’s interesting because I had applied because I felt like I was getting older and I would\r\n" + 
//        		"        never have another chance to apply. And so I was 38 at the time and my friend Leland Melvin, who was in the\r\n" + 
//        		"        Astronaut Corps, called and said, hey, we’re accepting applications for the Astronaut Corps and you should think\r\n" + 
//        		"        about applying this year. And I kind of thought about it, and it took me about two months to think about it, and\r\n" + 
//        		"        I finally said, well, you know, I may as well at least give it one shot. And so my advice to everyone, whoever\r\n" + 
//        		"        even ever thought about applying to the Astronaut Corps, I say just do it. And you can’t play if you don’t apply\r\n" + 
//        		"        and you don’t – you don’t at least play in the game. And I was quite shocked to find out that I was selected\r\n" + 
//        		"        that time. I thought I would –</p>\r\n" + 
//        		"      <p>MS. EASTON: And you were one of 14 members in the 20<sup>th</sup> NASA class.</p>\r\n" + 
//        		"      <p>MS. EPPS: That’s affirmative, yep.</p>\r\n" + 
//        		"      <p>MS. EASTON: That’s affirmative. Is that – (laughter) –</p>\r\n" + 
//        		"      <p>MS. EPPS: No, that’s correct. (Laughter.)</p>\r\n" + 
//        		"      <p>MS. EASTON: Astronaut-speak. That’s great. That’s quite an honor.</p>\r\n" + 
//        		"      <p>MS. EPPS: It was. It’s definitely quite an honor. And at the time when I received the call, I mean, it was – it\r\n" + 
//        		"        was kind of emotional. Of course, you know, I was a little choked up, and I said yes. But afterwards it was – it\r\n" + 
//        		"        was quite emotional because I went – my mother was in the hospital at the time and I went and told her, and the\r\n" + 
//        		"        fact that she was so happy for me was – that kind of broke the well, and you know, I just kind of started\r\n" + 
//        		"        gushing there because she thought –</p>\r\n" + 
//        		"      <p>MS. EASTON: Her pride must have been enormous.</p>\r\n" + 
//        		"      <p>MS. EPPS: Oh, it was. And, you know, the fact that she hated everything that I did before and she thought it\r\n" + 
//        		"        was very dangerous, and she knew that this would be just as bad but she was very happy – (laughter) – at that\r\n" + 
//        		"        point. So she was extremely glad that I got in.</p>\r\n" + 
//        		"      <p>MS. EASTON: It’s hard not to be proud if your kid’s an astronaut, right?</p>\r\n" + 
//        		"      <p>MS. EPPS: Yes.</p>\r\n" + 
//        		"      <p>MS. EASTON: And by the way, speaking of which, there are photos. You can see her in action since you didn’t\r\n" + 
//        		"        wear your –</p>\r\n" + 
//        		"      <p>MS. EPPS: With my mom.</p>\r\n" + 
//        		"      <p>MS. EASTON: Is your mom in them?</p>\r\n" + 
//        		"      <p>MS. EPPS: Oh, there’s – we have one picture with my mom in there, yeah.</p>\r\n" + 
//        		"      <p>MS. EASTON: OK. I’ll watch for it and point it out when it comes up. You didn’t wear your astronaut suit\r\n" + 
//        		"        tonight.</p>\r\n" + 
//        		"      <p>MS. EPPS: No. (Laughter.)</p>\r\n" + 
//        		"      <p>MS. EASTON: Oh well.</p>\r\n" + 
//        		"      <p>MS. EPPS: You guys didn’t ask, so. (Laughter.)</p>\r\n" + 
//        		"      <p>MS. EASTON: We should have. We should have done it.</p>\r\n" + 
//        		"      <p>MS. EPPS: Next time.</p>\r\n" + 
//        		"      <p>MS. EASTON: So describe your training. So the training you were – the idea was, when you joined the NASA class,\r\n" + 
//        		"        that it would be towards going to the space station? Was that –</p>\r\n" + 
//        		"      <p>MS. EPPS: Exactly.</p>\r\n" + 
//        		"      <p>MS. EASTON: OK. So describe that.</p>\r\n" + 
//        		"      <p>MS. EPPS: Well, we knew that the space shuttle would be retired around 2011, so we knew that my class would not\r\n" + 
//        		"        fly on the shuttle. We were slated to fly on the Soyuz. And so that meant when we came in we had to do the\r\n" + 
//        		"        Russian language. We had to –</p>\r\n" + 
//        		"      <p>MS. EASTON: And so just to back up a second for general audience folks, so the Soyuz now – since the space\r\n" + 
//        		"        shuttle’s been retired, the Soyuz is the only – which is Russian-built –</p>\r\n" + 
//        		"      <p>MS. EPPS: Exactly.</p>\r\n" + 
//        		"      <p>MS. EASTON: – is the only way to get humans to the space station and back.</p>\r\n" + 
//        		"      <p>MS. EPPS: That’s correct, yeah.</p>\r\n" + 
//        		"      <p>MS. EASTON: So that requires you to go to –</p>\r\n" + 
//        		"      <p>MS. EPPS: Star City, Russia.</p>\r\n" + 
//        		"      <p>MS. EASTON: Star City, Russia, in Kazakhstan.</p>\r\n" + 
//        		"      <p>MS. EPPS: Yes.</p>\r\n" + 
//        		"      <p>MS. EASTON: So what is that like?</p>\r\n" + 
//        		"      <p>MS. EPPS: Well, that’s – initially it was a little daunting because we were taking classes, it’s all in\r\n" + 
//        		"        Russian. We do have an interpreter there. But our exams are such that, you know, we’re sitting in front of the\r\n" + 
//        		"        room like this and we have about – a panel of people who quiz you on everything that you’re supposed to know, be\r\n" + 
//        		"        it on the Russian segment, be it on the Soyuz, the navigation system, the thermal control system. And they\r\n" + 
//        		"        really quiz you. And so it was – it was quite daunting. But, you know, after a while you kind of figure out that\r\n" + 
//        		"        the Russians, I think they – the way the exams are conducted, they’re very fair but they’re very difficult. And\r\n" + 
//        		"        so as long as you do your work, they – you know, you have no problem with the exams because they give you all\r\n" + 
//        		"        the data ahead of time. You just have to study the information and answer. And once you get through that kind of\r\n" + 
//        		"        phase, they kind of develop a – you kind of develop a friendship with them. They know you. They know how well\r\n" + 
//        		"        you’ll do. They kind of expect things of you in that sense.</p>\r\n" + 
//        		"      <p>MS. EASTON: So what about the other parts of the training? Describe the physical – the difficult stuff.</p>\r\n" + 
//        		"      <p>MS. EPPS: OK. Yeah, like the water survival.</p>\r\n" + 
//        		"      <p>MS. EASTON: OK. Let’s describe that.</p>\r\n" + 
//        		"      <p>MS. EPPS: The water survival is quite interesting because what they do is they put you in the Sokol suit, which\r\n" + 
//        		"        is their version of the pumpkin suit that we wear – the orange suit that you see our astronauts wear. They put\r\n" + 
//        		"        you in your suit, you put on your helmet, and you get inside one of their Soyuz modules and it’s just the\r\n" + 
//        		"        descent module. And it was me, our commander, and Alex Gerst. Alex Gerst is 6’2” and Aleksandr Samokutyayev is\r\n" + 
//        		"        probably about 6’1”. So it’s a very small compartment inside the Soyuz – extremely small. They close the hatch\r\n" + 
//        		"        and you basically – they put you in the water and what they want to simulate is a water landing during the cold.\r\n" + 
//        		"        And so what you have to do while you’re in there is you have to take off your Sokol suit and put on all of your\r\n" + 
//        		"        winter clothes and then put on a waterproof suit and –</p>\r\n" + 
//        		"      <p>MS. EASTON: Oh, geez. All three of you, like, crammed together. OK.</p>\r\n" + 
//        		"      <p>MS. EPPS: All three of us crammed together. So you have to do it one at a time.</p>\r\n" + 
//        		"      <p>MS. EASTON: OK.</p>\r\n" + 
//        		"      <p>MS. EPPS: And there’s no cooling. So our body temperatures get up to about 101 as we’re doing this.</p>\r\n" + 
//        		"      <p>MS. EASTON: Oh, wow.</p>\r\n" + 
//        		"      <p>MS. EPPS: Yes, because it’s just so hot inside the Soyuz itself.</p>\r\n" + 
//        		"      <p>MS. EASTON: Yeah.</p>\r\n" + 
//        		"      <p>MS. EPPS: And so because of that, that’s why a lot of people don’t like it and then you’re on the water and\r\n" + 
//        		"        you’re kind of moving around a little bit.</p>\r\n" + 
//        		"      <p>MS. EASTON: So how did you – and when you’re in that kind of situation, how do you muster the wherewithal to\r\n" + 
//        		"        get through it and to make it happen?</p>\r\n" + 
//        		"      <p>MS. EPPS: Well, I think we all knew what was supposed to happen. Alex – both Alex and Sasha had gone through\r\n" + 
//        		"        this before. I was the new person, and they both really kind of rallied around me and got me through it as well\r\n" + 
//        		"        because it’s really hot and it’s not – it’s not anything that’s so difficult. You just become so exhausted from\r\n" + 
//        		"        the heat that you have to basically work, work, work, work, take a break, then work, work, work, take a break,\r\n" + 
//        		"        work, work, work, take a break. And Sasha kind of got me through that cadence of work hard, work hard, work\r\n" + 
//        		"        hard, OK, take a short break, and then once we were all suited up we have to open the hatch and then we climb\r\n" + 
//        		"        out of the Soyuz.</p>\r\n" + 
//        		"      <p>MS. EASTON: And how was that?</p>\r\n" + 
//        		"      <p>MS. EPPS: Oh, you basically fall backwards, you blow up your suit, and you’re cool. You’re finally – you’re\r\n" + 
//        		"        just happy at that point.</p>\r\n" + 
//        		"      <p>MS. EASTON: You’re done. (Laughter.)</p>\r\n" + 
//        		"      <p>MS. EPPS: Yeah, you’re just happy.</p>\r\n" + 
//        		"      <p>MS. EASTON: And how does – how long does this whole exercise last?</p>\r\n" + 
//        		"      <p>MS. EPPS: Oh, it’s about two and a half hours.</p>\r\n" + 
//        		"      <p>MS. EASTON: Oh, wow.</p>\r\n" + 
//        		"      <p>MS. EPPS: Yes, because we each have to change out of our Sokol suit.</p>\r\n" + 
//        		"      <p>MS. EASTON: Is that – what’s that? What –</p>\r\n" + 
//        		"      <p>MS. EPPS: Oh, that’s actually the underwater experiment that NASA does and that’s the NEEMO experiment. It’s\r\n" + 
//        		"        called the NASA Extreme Environment Mission Operations, and you live underwater in a habitat for about – in my\r\n" + 
//        		"        group we stayed underwater for about nine days. So you do practice –</p>\r\n" + 
//        		"      <p>MS. EASTON: You stayed underwater for nine days?</p>\r\n" + 
//        		"      <p>MS. EPPS: Yes, in a little module, a little habitat that’s similar to what you would see on a space station,\r\n" + 
//        		"        about the same size, with six people. There were six of us. It was me and five guys. Yeah, Jeanette – it was not\r\n" + 
//        		"        fun.</p>\r\n" + 
//        		"      <p>MS. EASTON: So how big was it, like, from this – use this stage as an example.</p>\r\n" + 
//        		"      <p>MS. EPPS: OK. So it was probably maybe two more platforms longer than this. But that was it, and we had a wet\r\n" + 
//        		"        room where you have to change out into your scuba gear. You come in and then you have the kitchen and sort of\r\n" + 
//        		"        the living compartment and then we have the bunk beds in the last part of the compartment.</p>\r\n" + 
//        		"      <p>MS. EASTON: And then were you doing, like, experiments all day? What are you –</p>\r\n" + 
//        		"      <p>MS. EPPS: We were.</p>\r\n" + 
//        		"      <p>MS. EASTON: OK.</p>\r\n" + 
//        		"      <p>MS. EPPS: We were doing practice missions from the habitat to simulate if we landed on an asteroid – how would\r\n" + 
//        		"        we extract samples from an asteroid. So we have to set up certain type of equipment that was developed to\r\n" + 
//        		"        simulate how we would extract core samples from –</p>\r\n" + 
//        		"      <p>MS. EASTON: An asteroid?</p>\r\n" + 
//        		"      <p>MS. EPPS: Yes.</p>\r\n" + 
//        		"      <p>MS. EASTON: That’s pretty amazing. OK.</p>\r\n" + 
//        		"      <p>MS. EPPS: Yeah. And so we had the Mark V helmet on and the wetsuit and we kind of simulate space walks on the\r\n" + 
//        		"        bottom of the ocean, and we were only about 72 feet on the bottom and we lived at about 50 feet. So our\r\n" + 
//        		"        compartment was on a little platform 50 feet below the surface and then you leave that and you’re about 72 feet\r\n" + 
//        		"        below the surface.</p>\r\n" + 
//        		"      <p>MS. EASTON: Wow. So what was – what was the hardest training of all?</p>\r\n" + 
//        		"      <p>MS. EPPS: So I’d have to say, for me, you know, as an ASCAN, I think the hardest training was the neutral\r\n" + 
//        		"        buoyancy lab where you have to do the practice spacewalks and that’s partly because it’s very –</p>\r\n" + 
//        		"      <p>MS. EASTON: You practice spacewalks?</p>\r\n" + 
//        		"      <p>MS. EPPS: Yes.</p>\r\n" + 
//        		"      <p>MS. EASTON: So you’re practicing getting out of a vehicle and actually walking in space –</p>\r\n" + 
//        		"      <p>MS. EPPS: Exactly.</p>\r\n" + 
//        		"      <p>MS. EASTON: – just to make it clear to everybody. OK.</p>\r\n" + 
//        		"      <p>MS. EPPS: And what we do at Johnson Space Flight Center is we simulate that using a huge pool. The pool is\r\n" + 
//        		"        about a hundred feet wide, 200 feet long, and 40 feet deep, and we have a mockup of the main truss of the space\r\n" + 
//        		"        station. And so we don the space suit, which is about 300 pounds, and we have a bunch of divers that –</p>\r\n" + 
//        		"      <p>MS. EASTON: The space suit itself is 300 pounds?</p>\r\n" + 
//        		"      <p>MS. EPPS: Yes.</p>\r\n" + 
//        		"      <p>MS. EASTON: OK.</p>\r\n" + 
//        		"      <p>MS. EPPS: And so they have to make it neutrally buoyant, which simulates zero gravity.</p>\r\n" + 
//        		"      <p>MS. EASTON: It’s the weight of a man and a half, basically? I mean, just –</p>\r\n" + 
//        		"      <p>MS. EPPS: Yes, exactly.</p>\r\n" + 
//        		"      <p>MS. EASTON: Wow. OK.</p>\r\n" + 
//        		"      <p>MS. EPPS: But what they do is they make you neutrally buoyant so you shouldn’t ever really feel the 300 pounds.\r\n" + 
//        		"        As the suit starts taking on water, they kind of change your way out a little bit to make you – to get you back\r\n" + 
//        		"        to neutral buoyancy.</p>\r\n" + 
//        		"      <p>MS. EASTON: There’s your mom, by the way.</p>\r\n" + 
//        		"      <p>MS. EPPS: Yes. That’s – that was my mom. Yes.</p>\r\n" + 
//        		"      <p>MS. EASTON: OK. Sorry. Go ahead. Yeah.</p>\r\n" + 
//        		"      <p>MS. EPPS: And so we do – we get into the suit. They lower us into the water and we have a bunch of divers that\r\n" + 
//        		"        help us. But we do that for about six hours. You’re in the suit for six hours, and it’s very physical and it\r\n" + 
//        		"        becomes – because it exhausts you, it becomes very mental as well. So you have to make it through the – to the\r\n" + 
//        		"        end of the six hours, and after doing it so many years you kind of get used to the six hours in the suit under\r\n" + 
//        		"        water and you only have 32 ounces of water and you have a MAG, and I always – I love telling the story because\r\n" + 
//        		"        kids get a kick out of it.</p>\r\n" + 
//        		"      <p>Do you know what a MAG is? Does anyone know what a MAG is? You guys can’t guess? So we wear it under the\r\n" + 
//        		"        spacesuit. It’s a maximum absorbency garment. So it’s a diaper. (Laughter.) Don’t tell anyone. So but you do\r\n" + 
//        		"        that because you’re in the water for six hours and you have 32 ounces of water and that’s it, and you have to –\r\n" + 
//        		"        you know, because there’s so many resources that are used during these events you have to get as much done –</p>\r\n" + 
//        		"      <p>MS. EASTON: So you’re basically wearing a diaper the whole time if you’re – speaking to them. OK.</p>\r\n" + 
//        		"      <p>MS. EPPS: No, not right now. (Laughter.)</p>\r\n" + 
//        		"      <p>MS. EASTON: Yeah. No. (Laughter.)</p>\r\n" + 
//        		"      <p>MS. EPPS: Yeah. When you’re in the pool, yes. Yeah. So –</p>\r\n" + 
//        		"      <p>MS. EASTON: Yeah. For six hours.</p>\r\n" + 
//        		"      <p>MS. EPPS: Six hours, yes. That’s part of the uniform.</p>\r\n" + 
//        		"      <p>MS. EASTON: Yeah.</p>\r\n" + 
//        		"      <p>MS. EPPS: So and it’s necessary. So people always ask about the diaper – where does it come from – but that’s\r\n" + 
//        		"        where it comes from.</p>\r\n" + 
//        		"      <p>MS. EASTON: Oh, that’s –</p>\r\n" + 
//        		"      <p>MS. EPPS: Yeah.</p>\r\n" + 
//        		"      <p>MS. EASTON: And so what was – you said it – you cited it as the most difficult of your training. Why is that?\r\n" + 
//        		"      </p>\r\n" + 
//        		"      <p>MS. EPPS: Yes. Only because it’s very physical because when you’re in the pool and then the suit starts taking\r\n" + 
//        		"        on water, you start feeling some of that 300 pounds. So that’s why we do a lot of weightlifting and things like\r\n" + 
//        		"        that. But for the endurance we do a lot of cardio work, too. So CrossFit is great. You know, I do a lot of cross\r\n" + 
//        		"        training and crab classes and things like that as well. So –</p>\r\n" + 
//        		"      <p>MS. EASTON: So how much – how much workout do you do? Like, how far can you run? How far do you typically run –\r\n" + 
//        		"      </p>\r\n" + 
//        		"      <p>MS. EPPS: Well, some people do marathons. I don’t do marathons just yet. I really haven’t signed up to do any\r\n" + 
//        		"        of those. But, I mean, on a given day you could do 4 ½ miles and then go do some weightlifting or do pushups and\r\n" + 
//        		"        you really have to keep your body in shape and strong enough to do the spacewalk.</p>\r\n" + 
//        		"      <p>MS. EASTON: So in 2017 – last year – you were selected for the International Space Station after how many years\r\n" + 
//        		"        of training?</p>\r\n" + 
//        		"      <p>MS. EPPS: And so I had been training since February 2016.</p>\r\n" + 
//        		"      <p>MS. EASTON: So you had some serious training?</p>\r\n" + 
//        		"      <p>MS. EPPS: It’s two years. Yes. Yeah, it’s two years.</p>\r\n" + 
//        		"      <p>MS. EASTON: Yeah, going on for that. You were picked for – well, describe your emotions when you found out that\r\n" + 
//        		"        you were going to be chosen.</p>\r\n" + 
//        		"      <p>MS. EPPS: Well, I was in Russia doing language immersion at the time. So I was living in Moscow for five weeks\r\n" + 
//        		"        and going through the language immersion and about the fourth week in the chief of the office at that time,\r\n" + 
//        		"        Chris Cassidy, sent me an email, because he was on his way to Japan and he thought he’d send me an email before\r\n" + 
//        		"        he went over there, and asked if I wanted to have the mission 5657 to the International Space Station. And, of\r\n" + 
//        		"        course, when I saw that email I said – you know, I was going to send back a note, oh, no, that’s OK. No. Of\r\n" + 
//        		"        course, I was excited – extremely excited, and I thanked Chris and that began a whole new training over in Star\r\n" + 
//        		"        City and then in Germany and Japan.</p>\r\n" + 
//        		"      <p>MS. EASTON: And what were you doing in Germany and Japan?</p>\r\n" + 
//        		"      <p>MS. EPPS: Well, one of the things we do is we take all of their classes on the European module that’s aboard\r\n" + 
//        		"        the space station called the Columbus and the same for the Japanese module called the JEM, and what we do is we\r\n" + 
//        		"        can either train to be a user of their systems and their module, an operator, or a specialist, and what I did\r\n" + 
//        		"        was the specialist training you have a lot more – you have about two more weeks of training in Japan. And so for\r\n" + 
//        		"        both the Columbus and the Japanese module, I trained to become a specialist on their modules.</p>\r\n" + 
//        		"      <p>MS. EASTON: So you were also making history. You were going to become, believe it or not, the first African\r\n" + 
//        		"        American on the space station. There has not been one for long term to stay – an African-American astronaut to\r\n" + 
//        		"        stay long term.</p>\r\n" + 
//        		"      <p>MS. EPPS: That’s correct. That’s correct.</p>\r\n" + 
//        		"      <p>MS. EASTON: You were going to be that person.</p>\r\n" + 
//        		"      <p>MS. EPPS: Yes. We’ve had Mae Jemison. We have people like Al Drew, Leland Melvin. They all visited the space\r\n" + 
//        		"        station. Well, Mae Jemison didn’t visit the space station but they’ve all been in space, but it was for a short\r\n" + 
//        		"        time. And so what I would have done was actually live aboard the space station for about five to six months.</p>\r\n" + 
//        		"      <p>MS. EASTON: And the reason you’re saying would have, for people who don’t know this, is that in early last year\r\n" + 
//        		"        you were pulled from a June four months hence launch.</p>\r\n" + 
//        		"      <p>MS. EPPS: That is correct. Yes.</p>\r\n" + 
//        		"      <p>MS. EASTON: And talk about – you know, typically being pulled at that late date would have to be for health\r\n" + 
//        		"        reasons, something pretty obvious.</p>\r\n" + 
//        		"      <p>MS. EPPS: Yeah.</p>\r\n" + 
//        		"      <p>MS. EASTON: But that wasn’t the case.</p>\r\n" + 
//        		"      <p>MS. EPPS: No, that was not the case, and so, you know, for reasons that I can’t – I don’t really understand at\r\n" + 
//        		"        this point, my management – it was a management decision at the time and, you know, one of the things I can say\r\n" + 
//        		"        is that we’re still working through that. There have been several things that have happened on the space station\r\n" + 
//        		"        recently so I really haven’t found out much information lately. And so we’re still kind of working through those\r\n" + 
//        		"        issues and figuring out what’s going to happen for the future. And at this time I really don’t have a planned\r\n" + 
//        		"        mission yet, and we’ll see what happens in the future.</p>\r\n" + 
//        		"      <p>MS. EASTON: And so that created – that generated headlines, I mean –</p>\r\n" + 
//        		"      <p>MS. EPPS: Yes.</p>\r\n" + 
//        		"      <p>MS. EASTON: – and all sorts of questions about whether this was their – race was a motive, whether the Russians\r\n" + 
//        		"        had something to do with it. What was your take on all of that?</p>\r\n" + 
//        		"      <p>MS. EPPS: Well, you know, one of the things that I always put there is that my work with the Russians was\r\n" + 
//        		"        always very friendly, very warm, going through all of the training to the end, even in Baikonur – all of the\r\n" + 
//        		"        things that we did out there, it was phenomenal training. I mean, I can’t say anything negative about the\r\n" + 
//        		"        training that I got there.</p>\r\n" + 
//        		"      <p>So I wouldn’t say that the Russians had anything to do with this. I can’t say a hundred percent that no, they\r\n" + 
//        		"        didn’t; in my opinion, I don’t think that they did.</p>\r\n" + 
//        		"      <p>Whether race played an issue, I don’t know what’s in the mind of other people, and I can’t say that, oh,\r\n" + 
//        		"        definitely, or anything like that. So I’m not quite sure of the reasons myself. I do think – I do see a lot in\r\n" + 
//        		"        the media of people speculating but, you know, it is all speculation at this point.</p>\r\n" + 
//        		"      <p>MS. EASTON: And how are you dealing with this internally, emotionally? How are you getting through this?</p>\r\n" + 
//        		"      <p>MS. EPPS: Well, I’ll say that initially it was tough and – because I was in Baikonur when this happened. I was\r\n" + 
//        		"        in Star City and then I went on to Baikonur after that. So it was really tough dealing with it at that point\r\n" + 
//        		"        because I really didn’t know what happened.</p>\r\n" + 
//        		"      <p>And one of the nice things, though, when I got back was the number of people who came to me, and they actually\r\n" + 
//        		"        thought that I was sick or something happened to me. And so that was their first concern, and then, you know,\r\n" + 
//        		"        their – not just sympathy, but their desire to help and try to figure out what happened.</p>\r\n" + 
//        		"      <p>It is a really – it was really a bad thing that happened, but the friends that showed up and have really been\r\n" + 
//        		"        helping me, it has been tremendous.</p>\r\n" + 
//        		"      <p>MS. EASTON: So what is your – I know you are still in it – you’re not looking back yet – but what’s your – what\r\n" + 
//        		"        kind of advice or takeaway do you have when you are dealt such a setback? Your dream was there, you did\r\n" + 
//        		"        everything you were supposed to be doing, and then the rug was pulled out from under you. How do you cope?</p>\r\n" + 
//        		"      <p>MS. EPPS: Well, I think I’m talking about it, like even in this environment, and letting little girls know\r\n" + 
//        		"        that, hey, you know, things happen, but how you deal with it is important. And going through this doesn’t change\r\n" + 
//        		"        the things that I was able to accomplish. It does make me want to coach little girls, especially on, you know,\r\n" + 
//        		"        you can go on merit for a long time, but understanding the culture of any organization that you are in is going\r\n" + 
//        		"        to come into play at some point, and so trying to figure out how I can contribute and try to help other girls\r\n" + 
//        		"        and women not let this happen to them, and what are the things that you can do. And, you know, thinking about\r\n" + 
//        		"        the mistakes that I may have made, and how do I mitigate those, and what advice would I give other people going\r\n" + 
//        		"        through stuff.</p>\r\n" + 
//        		"      <p>MS. EASTON: What advice would you give to –</p>\r\n" + 
//        		"      <p>MS. EPPS: Well, one of the things – you know, it’s things like that, you know. Make sure you have – you do\r\n" + 
//        		"        everything to an excellent level, make sure your merit is very high, but at the same time, understand the\r\n" + 
//        		"        culture that you are working in because every culture is different. Going from Ford Motor Company to the CIA to\r\n" + 
//        		"        NASA, every culture is very different, and you have to acclimate to that. And if you come in quickly and you\r\n" + 
//        		"        don’t understand, you can make mistakes.</p>\r\n" + 
//        		"      <p>But the culture isn’t – it shouldn’t the end all and be all. You have to understand it, though. And that’s one\r\n" + 
//        		"        of the big pieces of advice – like my niece is going to school, and she’s wondering why – why is this happening,\r\n" + 
//        		"        why is that happening, and you know, helping her to understand that, you know, sometimes people aren’t nice and\r\n" + 
//        		"        things don’t go the way you want, but how you handle it is going to be the most important thing.</p>\r\n" + 
//        		"      <p>MS. EASTON: And you still hope to do – to be deployed?</p>\r\n" + 
//        		"      <p>MS. EPPS: I am still hoping. I’m back in the corps. Once I return in January – I went back to recertify on the\r\n" + 
//        		"        T-38; I had been out of the jet for over 45 days –</p>\r\n" + 
//        		"      <p>MS. EASTON: Tell everybody what a T-38 –</p>\r\n" + 
//        		"      <p>MS. EPPS: Oh, I’m sorry. The T-38 jet is a supersonic trainer jet that the Navy and the Air Force use to train\r\n" + 
//        		"        their pilots, and because I’m a back seat, the front-seat pilots help train me to work with them, not just in a\r\n" + 
//        		"        high threat environment, but also we use it as crew resource management – so how do we work together as a crew.\r\n" + 
//        		"        All of this should translate to how we work together in space.</p>\r\n" + 
//        		"      <p>MS. EASTON: So just one other question before we go in that a little more broadly about NASA. What you do is\r\n" + 
//        		"        extremely dangerous –</p>\r\n" + 
//        		"      <p>MS. EPPS: Yes.</p>\r\n" + 
//        		"      <p>MS. EASTON: – let’s be real. I mean, people have been killed and will be killed in manned space travel.</p>\r\n" + 
//        		"      <p>MS. EPPS: Yes, I agree.</p>\r\n" + 
//        		"      <p>MS. EASTON: How do you deal with that risk?</p>\r\n" + 
//        		"      <p>MS. EPPS: Well, I think understanding what you are getting into first of most importance. I mean, sometimes you\r\n" + 
//        		"        can see people walk into things and totally not understand what they are getting into – but understanding the\r\n" + 
//        		"        risk and then mitigating that through training and understanding.</p>\r\n" + 
//        		"      <p>One of the things we recently had happened was depressurization of the space station, and that’s one of the\r\n" + 
//        		"        emergency procedures that we train ad nauseam on how to handle a rapid depress aboard the space station. We\r\n" + 
//        		"        train heavily on how to handle a fire aboard the space station. We have ammonia in the U.S. segment, so that can\r\n" + 
//        		"        actually enter into the cabin, and because it is anhydrous ammonia, you know, it can be deadly. So we train on\r\n" + 
//        		"        what we would do if we had an ammonia leak into the space station. And we train those over and over and over\r\n" + 
//        		"        again so it’s muscle memory pretty much once – and if it happens.</p>\r\n" + 
//        		"      <p>And that’s what happened in August. You saw the training snap in, and these guys got to work, and they found\r\n" + 
//        		"        the leak, and they isolated it to one of the Soyuz.</p>\r\n" + 
//        		"      <p>MS. EASTON: So speaking of issues, on October 11th, there was the accident – a Soyuz failed to launch – what\r\n" + 
//        		"        was it, 2 ½ minutes after liftoff the astronauts basically had to bail. And I have to ask you what it’s like to\r\n" + 
//        		"        fall 31 miles after your rocket fails.</p>\r\n" + 
//        		"      <p>MS. EPPS: So I haven’t talked to Nick Hague since he returned from that, but the great thing is that that is\r\n" + 
//        		"        another thing that the Russians train you to do ad nauseam, and a lot of our training has to do with going\r\n" + 
//        		"        through procedures, but also mainly executing emergency procedures when it’s necessary. So his training snapped\r\n" + 
//        		"        in, and they were able to get out of there in time and survive.</p>\r\n" + 
//        		"      <p>But that can happen any time; that’s why we train the way we do. It is a risky job, but I think working at the\r\n" + 
//        		"        CIA can be risky, too. (Laughter.) And so any job that you –</p>\r\n" + 
//        		"      <p>MS. EASTON: Do you mean the job that you don’t want to talk about? The one – (laughter) –</p>\r\n" + 
//        		"      <p>MS. EPPS: Or any of these jobs can be risky.</p>\r\n" + 
//        		"      <p>MS. EASTON: (Laughing.) OK.</p>\r\n" + 
//        		"      <p>MS. EPPS: And so you really have to understand what you are getting into, and through understanding and\r\n" + 
//        		"        training is how we mitigate the problems and the worry.</p>\r\n" + 
//        		"      <p>MS. EASTON: So I want to pause now and remind everybody that we’d love to take your questions. Write them on\r\n" + 
//        		"        cards. We’ll have people picking them up as I continue with some questions, and we also have – you can – if you\r\n" + 
//        		"        are tweeting, the hashtag of course is #SmartWomenSmartPower, or @CSISAerospace.</p>\r\n" + 
//        		"      <p>So generally, can you give us your vision of how space travel is going to be in the future – manned and\r\n" + 
//        		"        unmanned, Moon and Mars? I mean, what’s going – take us through the next five to ten years.</p>\r\n" + 
//        		"      <p>MS. EPPS: OK, so one of the things is right now we don’t launch from U.S. soil, but hopefully over the next two\r\n" + 
//        		"        to three years we’ll launch from the U.S. soil. We’ll have either a Boeing or a SpaceX launching and going only\r\n" + 
//        		"        to the space station.</p>\r\n" + 
//        		"      <p>MS. EASTON: And so these are – basically these are private sector solutions to the fact that we lost the\r\n" + 
//        		"        shuttle – or the shuttle was –</p>\r\n" + 
//        		"      <p>MS. EPPS: Exactly. You know, we had to do that because we had the Constellation program going as well, and it’s\r\n" + 
//        		"        really hard to fund both programs. So we knew that we were going to retire the shuttle and something else bigger\r\n" + 
//        		"        was going to come along.</p>\r\n" + 
//        		"      <p>MS. EASTON: OK.</p>\r\n" + 
//        		"      <p>MS. EPPS: And what that is is the Orion program, and so the Orion’s job is to take us to the Moon, and\r\n" + 
//        		"        hopefully, in the future, to Mars. But in the meantime we need to develop an engineering test bed to get to\r\n" + 
//        		"        Mars. So everything that we do at the Moon – all of the technologies that we develop, all of the things that we\r\n" + 
//        		"        find out about the human body and how it survives in lower gravity – everything that we find out radiation-wise\r\n" + 
//        		"        as well, all of that information will help get us to Mars.</p>\r\n" + 
//        		"      <p>So we’re planning to have a gateway platform that would go around the Moon, and basically we would launch the\r\n" + 
//        		"        Orion from earth on the SLS, which is our – should be our larger than Saturn V rocket to get us to the Moon,\r\n" + 
//        		"        dock to the gateway, have astronauts stay there for months maybe. But everything that we would find out from the\r\n" + 
//        		"        astronauts working there on the surface and working on the platform, the gateway, would translate to everything\r\n" + 
//        		"        that we can do to get to Mars.</p>\r\n" + 
//        		"      <p>MS. EASTON: OK, so tell these guys how long will it take – does it take to get to the Moon and how long does it\r\n" + 
//        		"        take to get to Mars.</p>\r\n" + 
//        		"      <p>MS. EPPS: Well, that’s – it depends on the rocket that we have. So right now we have the SLS, and what we’re\r\n" + 
//        		"        planning now is a couple of – hopefully we’ll have EM-1. That’s going to be a mission that will go around the\r\n" + 
//        		"        Moon, and that should be in 2022. And then shortly after that we should have a manned mission. And by 2025 we’re\r\n" + 
//        		"        going to give up the space station, and we’re going to actually stop funding it through federal funds, and\r\n" + 
//        		"        hopefully it’ll go commercial. And so once we do that we will – we will just be sending astronauts to the Moon\r\n" + 
//        		"        and staying on the Moon.</p>\r\n" + 
//        		"      <p>For getting to Mars, I can’t give you a good idea of how long it would take to get there. It depends on the\r\n" + 
//        		"        gravity assist and the alignment to get there, but – and then the propulsion system that we would develop. So\r\n" + 
//        		"        right now they’re looking at eight to nine months, but who knows what – if we develop a new propulsion system it\r\n" + 
//        		"        may take a shorter time than that.</p>\r\n" + 
//        		"      <p>MS. EASTON: Great.</p>\r\n" + 
//        		"      <p>MS. EPPS: Yes.</p>\r\n" + 
//        		"      <p>MS. EASTON: And I wanted to note that Director Gordon is backstage watching. And for online questions, you can\r\n" + 
//        		"        submit your online questions. Just go to aerospace.csis.org/questions.</p>\r\n" + 
//        		"      <p>What is – what are your thoughts regarding Space Force? And I picked this. (Laughs.)</p>\r\n" + 
//        		"      <p>MS. EPPS: Well, so from everything that I’ve heard about it, it’s basically going to be like the Space Command,\r\n" + 
//        		"        which is in the Air Force. And so there may not be a plus-up of people. Maybe it’s just transferring the Space\r\n" + 
//        		"        Command to be the next segment of the military, the Space Force.</p>\r\n" + 
//        		"      <p>So I don’t really have an opinion on it yet. I haven’t seen any real outline/plan for what it would be like,\r\n" + 
//        		"        and what they would do, and how they would – would they replace the astronauts? How do we work together to do\r\n" + 
//        		"        that? So I don’t know – have a lot of information on that just yet.</p>\r\n" + 
//        		"      <p>MS. EASTON: In general, though, what do you think of the militarization of space?</p>\r\n" + 
//        		"      <p>MS. EPPS: Well, so that is a great question. And you know, one of the questions about denuclearization and\r\n" + 
//        		"        putting weapons in space and things like that, I’m not necessarily a big fan of putting weapons in space. That,\r\n" + 
//        		"        to me, is – you know, it’s the start of something else. You know, I think denuclearizing it, everyone kinds of\r\n" + 
//        		"        stands down. But if you start doing that, everyone’s going to want to have that status symbol of having\r\n" + 
//        		"        something in space as well. So militarization of space, I can’t say that I’m for it, and I don’t know what that\r\n" + 
//        		"        would look like in the future. Yeah.</p>\r\n" + 
//        		"      <p>MS. EASTON: Great. So here’s a question from the audience: As a – as a woman, where there any special\r\n" + 
//        		"        challenges you encountered? And does being a woman give you any superpower/assets as an astronaut or scientist?\r\n" + 
//        		"      </p>\r\n" + 
//        		"      <p>MS. EPPS: Well, I would say that most women have a superpower in that they are very resilient and persistent,\r\n" + 
//        		"        in being very persistent and going after your goals and asking for opportunities. And that’s the thing, I think,\r\n" + 
//        		"        you know, as a female, I think I’ve done an OK job of in asking for opportunities to go do things. And so as I –\r\n" + 
//        		"        I think a lot of women have a resiliency as well. So when it gets tough you don’t just give up –</p>\r\n" + 
//        		"      <p>MS. EASTON: Give up.</p>\r\n" + 
//        		"      <p>MS. EPPS: – and go away, you just work harder, and you make sure that you achieve the goal that your colleagues\r\n" + 
//        		"        are – whatever goal they’re making, you’re making the same goal.</p>\r\n" + 
//        		"      <p>MS. EASTON: Great. This is a good one: What’s harder to learn, thermodynamics or Russian? (Laughter.)</p>\r\n" + 
//        		"      <p>MS. EPPS: I’d have to say Russian. (Laughter.) I’m still not speaking it fluently, but that’s because I haven’t\r\n" + 
//        		"        been over there in about eight months, so.</p>\r\n" + 
//        		"      <p>MS. EASTON: Right.</p>\r\n" + 
//        		"      <p>MS. EPPS: Yeah. You don’t use it, you lose it.</p>\r\n" + 
//        		"      <p>MS. EASTON: How many times did you apply for the Astronaut Corps?</p>\r\n" + 
//        		"      <p>MS. EPPS: Well, I was one of the very lucky ones; I only applied once. But I – my advice to people who haven’t\r\n" + 
//        		"        applied and they want to is that you have to go ahead and apply. If you don’t apply, you can’t play in the game.\r\n" + 
//        		"        Even if you don’t get that job, it is an experience to at least apply and see what happens. And that’s what I\r\n" + 
//        		"        did.</p>\r\n" + 
//        		"      <p>MS. EASTON: So this is one from one of our younger audience members: What do you do in your rocket? And I would\r\n" + 
//        		"        probably add to that: What do you do in the space station?</p>\r\n" + 
//        		"      <p>MS. EPPS: Yes. So in the Soyuz I was the left-seat person. So our commander, in the center, he basically had\r\n" + 
//        		"        the command of the Soyuz, and whatever he asked me to do that’s what I would do. He’s, monitor the pressure, I\r\n" + 
//        		"        would monitor the pressure; open the valve, I would open the valve. So you’re basically following procedures\r\n" + 
//        		"        inside the Soyuz.</p>\r\n" + 
//        		"      <p>But when you live on the space station, you are the research scientist for – you’re their hands and their eyes,\r\n" + 
//        		"        and so you’re conducting all of their research. One of the other things is that, as a person aboard the space\r\n" + 
//        		"        station, you’re an experiment in and of yourself as well, so you’ve got to figure out, you know – there’s a lot\r\n" + 
//        		"        of samples taken from you, a lot of blood samples. And they want to look at how your muscles behave in space\r\n" + 
//        		"        with training, with a lot of resistive training, so you do quite a few things aboard the space station.</p>\r\n" + 
//        		"      <p>MS. EASTON: So this is from one of our audience members who said: Sorry I had to leave early, but did you know\r\n" + 
//        		"        that an African-American engineer was one of the chief designers of the space suit for the first Moon mission?\r\n" + 
//        		"      </p>\r\n" + 
//        		"      <p>MS. EPPS: No, I did not know that.</p>\r\n" + 
//        		"      <p>MS. EASTON: And I would read the rest of this, but I can’t read the writing. (Laughter.) But that’s an\r\n" + 
//        		"        interesting one.</p>\r\n" + 
//        		"      <p>MS. EPPS: Yeah, that’s an interesting one.</p>\r\n" + 
//        		"      <p>MS. EASTON: We’ll check that out.</p>\r\n" + 
//        		"      <p>MS. EPPS: Yes.</p>\r\n" + 
//        		"      <p>MS. EASTON: Maybe we can Google that, somebody.</p>\r\n" + 
//        		"      <p>How do you feel about investment in commercial spaceflight? And would you like to operate in non-NASA rocket\r\n" + 
//        		"        spacecraft?</p>\r\n" + 
//        		"      <p>MS. EPPS: Well, I really like the work that the commercial entities are doing and pushing the envelope and\r\n" + 
//        		"        developing new things. So I think it’s a great idea to have commercial involved in anything that we do in space\r\n" + 
//        		"        and help keep – one of things is giving opportunities to non-astronauts to fly into space as well. So I think\r\n" + 
//        		"        the work that they’re doing is going to go along way, especially once we stop funding the space station around\r\n" + 
//        		"        2025. I think they’ll take it on pretty far.</p>\r\n" + 
//        		"      <p>MS. EASTON: This has a number of questions, I guess – I think also from one of our younger audience members.\r\n" + 
//        		"        What was the hardest part about training? We talked a bit about that. Did you meet any good friends while\r\n" + 
//        		"        training?</p>\r\n" + 
//        		"      <p>But it’s an interesting question, like, do you – what kind of bond do you create with fellow astronauts during\r\n" + 
//        		"        this?</p>\r\n" + 
//        		"      <p>MS. EPPS: Well, it does become difficult to make strong bonds with other astronauts, but you do, you end up\r\n" + 
//        		"        making strong –</p>\r\n" + 
//        		"      <p>MS. EASTON: It becomes difficult.</p>\r\n" + 
//        		"      <p>MS. EPPS: Well, only because everyone is off training and everyone is doing their own thing and they have to\r\n" + 
//        		"        get, you know, a certain amount of flying in, they have to get a certain amount of Russian in, and a lot of the\r\n" + 
//        		"        guys have their families with them in Houston.</p>\r\n" + 
//        		"      <p>And so one of the – one of the guys that I did become close with was Jack Fischer, who recently left and he\r\n" + 
//        		"        went to the Space Command in Colorado. He and his wife, we would regularly go to dinner and happy hour and chat.\r\n" + 
//        		"        And so you end up – we ended up – we did our training for robotics together as well in Canada. So through all of\r\n" + 
//        		"        the training that we ended up doing together, that’s how we became friends. But then there’s other people, like\r\n" + 
//        		"        even Sergey Prokopyev, when I would be in Star City and we’re training and living there, he would invite us to\r\n" + 
//        		"        different parties and things like that. And so there’s lots of ways to get, you know – especially as a crew, you\r\n" + 
//        		"        end up bonding very tightly being in water survival or winter survival, you end up becoming very close. And then\r\n" + 
//        		"        even some of the trainers, I’ve become very good friends with a lot of our trainers as well.</p>\r\n" + 
//        		"      <p>MS. EASTON: Because it would seem you would have to have some kind of bond if you’re – particularly when you’re\r\n" + 
//        		"        in difficult situations, you need to develop that level of trust –</p>\r\n" + 
//        		"      <p>MS. EPPS: Yes.</p>\r\n" + 
//        		"      <p>MS. EASTON: – and yet, you’re also kind of all on your own training systems. Yeah.</p>\r\n" + 
//        		"      <p>MS. EPPS: Exactly. And that’s how Jack and I became friends, going to Canada together and doing all of our\r\n" + 
//        		"        robotic skills together.</p>\r\n" + 
//        		"      <p>MS. EASTON: Do you believe aliens exist? And what is your basis for believing or not believing?</p>\r\n" + 
//        		"      <p>MS. EPPS: Well, when I think about our solar system, we’re one solar system in this huge galaxy, the Milky Way\r\n" + 
//        		"        Galaxy. But we’re one of billions of galaxies and there’s so many galaxies out there. So I would have to guess\r\n" + 
//        		"        that there has to be life somewhere else in one of these other galaxies.</p>\r\n" + 
//        		"      <p>MS. EASTON: Landing on Mars, what would that entail? What would that – what would the atmosphere be like?\r\n" + 
//        		"        Again, from one of our younger folks here.</p>\r\n" + 
//        		"      <p>MS. EPPS: Well, it’s going to be different than landing on the Moon because they have one-third the gravity\r\n" + 
//        		"        that we have on Earth, so it’s going to be a little bit different.</p>\r\n" + 
//        		"      <p>MS. EASTON: Start with just climate and temperature and –</p>\r\n" + 
//        		"      <p>MS. EPPS: Well, see, that’s the thing, they don’t really have an atmosphere the way we have here on Earth. So\r\n" + 
//        		"        we would have to synthesize all of that. So landing on Mars, we would have to be in our suit, we’d have to\r\n" + 
//        		"        provide our own pressure, we’d have to provide our own oxygen, we’d have to provide our own carbon dioxide\r\n" + 
//        		"        removal system. So it would be like being inside the spacewalk suit, so you really have to be contained inside\r\n" + 
//        		"        of this.</p>\r\n" + 
//        		"      <p>And then there’s a lot of dust and the dust can get into different systems and follow them. And so you want to\r\n" + 
//        		"        be careful that you don’t destroy your only spaceship, which is your suit, if you’re walking on the surface. So\r\n" + 
//        		"        you have to really develop special systems just for landing on the Moon and living there on Mars.</p>\r\n" + 
//        		"      <p>And the same thing for the Moon, though. You have to develop different systems of how we would handle that. So\r\n" + 
//        		"        that’s part of the job of going back to the Moon and developing all these CONOPS of how we would, if you had to\r\n" + 
//        		"        live on the Moon, how would we – and even just walking on the Moon, how would we do it better than what we did\r\n" + 
//        		"        before?</p>\r\n" + 
//        		"      <p>There was a lot of – there’s a thin layer of regolith on the Moon and it’s very – it’s a fine dust. And it gets\r\n" + 
//        		"        into all the different systems. And so you want to try to protect your ship, your suit, and the Lunar Module\r\n" + 
//        		"        that you’re in. So you – I think what we’re going to end up finding is that we’re going to do things differently\r\n" + 
//        		"        than what we did in the early Apollo days. And we’re going to develop – hopefully we can develop better systems\r\n" + 
//        		"        and make it –</p>\r\n" + 
//        		"      <p>MS. EASTON: And more permanent systems certainly on the Moon.</p>\r\n" + 
//        		"      <p>MS. EPPS: Yes, exactly, more permanent systems. And even on the Gateway Platform, you know, we do have an issue\r\n" + 
//        		"        with radiation, how do we protect from that? So we may have to have different types of suits that would have,\r\n" + 
//        		"        you know, a special material that would protect us from radiation.</p>\r\n" + 
//        		"      <p>MS. EASTON: Right.</p>\r\n" + 
//        		"      <p>MS. EPPS: So there’s a lot of things to think about when you start thinking about walking on Mars. You know, I\r\n" + 
//        		"        start thinking of the Moon initially of how we’re – how are we going to do that on the Moon, how are we going to\r\n" + 
//        		"        do it better than what we did before? What kind of Lunar buggy will we have? You know, the different types of\r\n" + 
//        		"        wheels and things that I’ve seen people develop and different rovers that I’ve seen develop, you know, which one\r\n" + 
//        		"        will we end up using? And which one will actually be the best? And then we can take that and use it on Mars.</p>\r\n" + 
//        		"      <p>MS. EASTON: What’s the coolest rover you’ve seen?</p>\r\n" + 
//        		"      <p>MS. EPPS: Well, so we’ve had – we’ve had different ones that had a spacesuit attached to the back where you\r\n" + 
//        		"        can, from your rover, you can get into a spacesuit and do a spacewalk from that rover. And so that’s one of the\r\n" + 
//        		"        – we used it in a program called Desert RATS. So a very nice rover that was developed at Johnson Space Center.\r\n" + 
//        		"        I’m not sure if we’d use something like that on the Moon this time, but hopefully we’ll develop systems that\r\n" + 
//        		"        will improve our experience there on the Moon the initial time and improve that and then we can use all of those\r\n" + 
//        		"        systems for Mars.</p>\r\n" + 
//        		"      <p>MS. EASTON: Does that appeal to you personally?</p>\r\n" + 
//        		"      <p>MS. EPPS: It does. You know, just –</p>\r\n" + 
//        		"      <p>MS. EASTON: Going to the Moon and Mars?</p>\r\n" + 
//        		"      <p>MS. EPPS: Yes, because we, you know, we went to the Moon all of six times. And, you know, what did we find out?\r\n" + 
//        		"        You know, it’s kind of like coming to the United States and visiting several places. You know, have we really\r\n" + 
//        		"        explored it? Have we really exploited it and know it so well that, you know, we can live there and we can do\r\n" + 
//        		"        other things that we – you know, extract resources if we needed to. So I would like to go back and investigate\r\n" + 
//        		"        it a little more, try to find out, you know, how did the Moon end up there? What happened to our planet and the\r\n" + 
//        		"        Moon? How did it get into that position? What pummeled it? Where did all of those pock marks and all the impact\r\n" + 
//        		"        craters on the Moon, where did they come from? So if we can study those impact craters, figure out what hit the\r\n" + 
//        		"        Moon, how it go into that position, you know, maybe we can mitigate things that could happen in the future and,\r\n" + 
//        		"        you know, help better – help, you know, what’s going on here on Earth as well.</p>\r\n" + 
//        		"      <p>MS. EASTON: I love that. What recommendations would you give to an 11-year-old girl who wishes to become an\r\n" + 
//        		"        astronaut for NASA like you?</p>\r\n" + 
//        		"      <p>MS. EPPS: My advice would be to continue to do well in school, excel in the STEM areas. And if you can, achieve\r\n" + 
//        		"        higher degrees, but also have a complete life. You know, go camping, do those things, be very athletic in these\r\n" + 
//        		"        things, learn another language. And, you know, once you’ve done all these things, make sure you have a career\r\n" + 
//        		"        that you absolutely love and the only thing that can take you from that career would be getting into the\r\n" + 
//        		"        Astronaut Corps. And then once you start applying for the Astronaut Corps, if you don’t get it the first time,\r\n" + 
//        		"        keep applying, continue to apply and try again.</p>\r\n" + 
//        		"      <p>MS. EASTON: But you have to get an undergrad, you have to study science and math.</p>\r\n" + 
//        		"      <p>MS. EPPS: Yes. I would – yes. I would say science, technology, engineering and mathematics or even, you know,\r\n" + 
//        		"        becoming a medical doctor as well is another route that a lot of people took. And that is included in the STEM.\r\n" + 
//        		"        But I want to make sure that you know that being an engineer is a great route, being a medical doctor, a\r\n" + 
//        		"        biologist, a chemist, all of these fields are great, or even becoming a fighter pilot yourself.</p>\r\n" + 
//        		"      <p>MS. EASTON: That works.</p>\r\n" + 
//        		"      <p>MS. EPPS: Yes. (Laughter.)</p>\r\n" + 
//        		"      <p>MS. EASTON: Online question: Does your training prepare you for long-duration flight around the Moon?</p>\r\n" + 
//        		"      <p>MS. EPPS: Yes, it does.</p>\r\n" + 
//        		"      <p>MS. EASTON: And describe that to a general audience here what that means.</p>\r\n" + 
//        		"      <p>MS. EPPS: Well, I think the way that we were training for the Soyuz is that – and we were training for – if we\r\n" + 
//        		"        were on the space station and there’s six of us, we all had to be certified in Russian, certified in robotics,\r\n" + 
//        		"        certified in being able to do a spacewalk, and that all means that you have to condition your body for doing a\r\n" + 
//        		"        spacewalk, you have to practice the robotics. We’re not – we do have data from the Apollo era of what happened\r\n" + 
//        		"        with the astronauts then, but we still have a lot of unknowns. So the training that we’re doing now is really\r\n" + 
//        		"        just – you know, we’re training for the unknown and whatever may come at us in the future. We may find out\r\n" + 
//        		"        something new on the Moon that we didn’t know before.</p>\r\n" + 
//        		"      <p>MS. EASTON: Right.</p>\r\n" + 
//        		"      <p>MS. EPPS: Radiation-wise, that could be an issue and we have to train differently for that.</p>\r\n" + 
//        		"      <p>MS. EASTON: So this is also an online question. At today’s rate of progress, who will win the race to Mars,\r\n" + 
//        		"        U.S., China or SpaceX?</p>\r\n" + 
//        		"      <p>MS. EPPS: Well, with the government, things do go a little slower, but I do think that the concern for safety\r\n" + 
//        		"        is very important. So things may go a little slower with the government, but I do think it will be as safe as we\r\n" + 
//        		"        can get it.</p>\r\n" + 
//        		"      <p>SpaceX, I do think that they care about safety as well. And they are moving at a more – probably at a faster\r\n" + 
//        		"        pace. I have – you know, Elon Musk says he’s going to do something and, you know, majority of the time he does\r\n" + 
//        		"        it. So I don’t know who will get there first, but I do know that working with NASA to get there will be the\r\n" + 
//        		"        safest route, I believe.</p>\r\n" + 
//        		"      <p>MS. EASTON: It’ll be more safe than SpaceX, is that what you’re –</p>\r\n" + 
//        		"      <p>MS. EPPS: Well, I wouldn’t – I can’t say safer than SpaceX or safer than this other company. I do know that\r\n" + 
//        		"        NASA has a safety record and I do know that they will probably take longer to make sure that the safety\r\n" + 
//        		"        regulations and everything that needs to happen will be in place. So I don’t want to say that it’ll be safer\r\n" + 
//        		"        than SpaceX because I’m not sure what they’ll end up doing. Yeah.</p>\r\n" + 
//        		"      <p>MS. EASTON: Doing. Another good question from online: What popular movie or TV show best depicts what\r\n" + 
//        		"        astronauts actually do during a mission? What’s the most realistic kind of movie or TV show you’ve seen?</p>\r\n" + 
//        		"      <p>MS. EPPS: Boy, that’s interesting. Well, I guess what I liken it to is that you’re living in space with friends\r\n" + 
//        		"        and you’re conducting experiments. You’re basically the hands and the eyes for every principal investigator that\r\n" + 
//        		"        has an experiment aboard the space station. And you’re living there as well. All your food is kind of uploaded\r\n" + 
//        		"        through some visiting vehicle, so you get a lot of logistics, you get your clothes, you have to exercise, so,\r\n" + 
//        		"        you know, it could be like living in a dorm almost, you know. So I don’t think – I don’t know of a television\r\n" + 
//        		"        show that can mimic it as well. I mean, you’re living your life like in an apartment and you have your own\r\n" + 
//        		"        little room. Food is upmassed, the food that you like is upmassed to you. You have to exercise. So I don’t know\r\n" + 
//        		"        else to liken that to.</p>\r\n" + 
//        		"      <p>MS. EASTON: Describe the food.</p>\r\n" + 
//        		"      <p>MS. EPPS: Oh, the food is – it’s like military food. A lot of it is irradiated for safety purposes. But in\r\n" + 
//        		"        general, you can get a lot of the foods that you like. I mean, there are still – you have sweet-and-sour chicken\r\n" + 
//        		"        or something like that. You have rice. If you have one of the Japanese astronauts with you, you may have a curry\r\n" + 
//        		"        dish, which is always nice. A lot of the Russian food is, you know, jellied fish or something like that, but\r\n" + 
//        		"        it’s actually not that bad. (Laughter.)</p>\r\n" + 
//        		"      <p>MS. EASTON: What’s your favorite?</p>\r\n" + 
//        		"      <p>MS. EPPS: Oh, well, the Russians have – they have something like this Hungarian beef in a can that is not bad\r\n" + 
//        		"        that I like.</p>\r\n" + 
//        		"      <p>MS. EASTON: OK.</p>\r\n" + 
//        		"      <p>MS. EPPS: And then the Europeans, if you have a European astronaut up there, you always have great food that’s\r\n" + 
//        		"        made by some chef, like some lemon pudding or something or chocolate cake. So it’s not – the food isn’t bad.\r\n" + 
//        		"        It’s like anything that you would eat here.</p>\r\n" + 
//        		"      <p>MS. EASTON: So what cool experiments are going on on the space station now?</p>\r\n" + 
//        		"      <p>MS. EPPS: Well, one of the things that I was involved in and looking at doing was a lot of the work with the\r\n" + 
//        		"        rodents, with the mice, and doing genetic studies. So basically, you work with the little mice. And in Japan\r\n" + 
//        		"        you’re just extracting a little blood from each mouse, and you’re sending it down, and you’re doing analysis on\r\n" + 
//        		"        that and how they change in space. So that’s one of the cool things.</p>\r\n" + 
//        		"      <p>We have a combustion rack. We have a fluids rack. We have a MAGVEC (ph) rack. We do several different\r\n" + 
//        		"        experiments in the European module right now.</p>\r\n" + 
//        		"      <p>And then there were several other things that we were going to do on each person. So looking at muscle density\r\n" + 
//        		"        over the body and seeing how that changes as you’re on the space station using a special tool that was\r\n" + 
//        		"        developed. So in general, there’s a ton of different experiments that’s done on the body, but then there’s\r\n" + 
//        		"        material science experiments that are conducted as well. So there’s tons of things going on right now that are a\r\n" + 
//        		"        lot of fun.</p>\r\n" + 
//        		"      <p>MS. EASTON: Great. So as we close tonight, give us your vision/argument for why manned space – or womaned –\r\n" + 
//        		"        manned space travel is important, because there’s a lot of people who think we should be spending that money\r\n" + 
//        		"        here on Earth. Why is it important?</p>\r\n" + 
//        		"      <p>MS. EPPS: Well, a lot of the research and things that are done are used to improve the life here on Earth as\r\n" + 
//        		"        well. So everything that we do in space, a lot of it can be applied to our life here on Earth. And the best\r\n" + 
//        		"        example that I like is the development of these bisphosphonates for osteoporosis. So one of the things is being\r\n" + 
//        		"        on orbit your bone density goes down because you’re not – you don’t have gravity as loading your bones. And now\r\n" + 
//        		"        that we do all of this exercise and we do resistive exercise, we don’t see that anymore. But there was also a\r\n" + 
//        		"        drug that was developed to help mitigate that as well.</p>\r\n" + 
//        		"      <p>MS. EASTON: To help mitigate it in space that can apply –</p>\r\n" + 
//        		"      <p>MS. EPPS: It can apply to Earth, though, here.</p>\r\n" + 
//        		"      <p>MS. EASTON: OK.</p>\r\n" + 
//        		"      <p>MS. EPPS: So some osteoporosis patients can benefit from that right now. And so that’s one example of how all\r\n" + 
//        		"        the things that we do for space can be applied here to make life better on Earth.</p>\r\n" + 
//        		"      <p>But also as, you know, the human race, I think that we are curious and we are explorers. We want to know more.\r\n" + 
//        		"        We want to – you look up in the sky and you see the Moon and you see all the splotches on the Moon and try to\r\n" + 
//        		"        figure out, well, what is that material? And then you send someone to the Moon, they bring back samples and you\r\n" + 
//        		"        realize that’s basalt. And then you realize that there’s something impacted the Moon, and what could that have\r\n" + 
//        		"        been? Could that have happened here on Earth? So answering questions as a human being, I think the curiosity in\r\n" + 
//        		"        finding out more, figuring out what happened to this planet and why did it evolve the way it did I think is an\r\n" + 
//        		"        age-old question that we’ve been asking ourselves for a long time as explorers. So I think that’s always going\r\n" + 
//        		"        to continue and I don’t think that it’ll ever wane where people won’t be curious about what’s out there and what\r\n" + 
//        		"        can we do to get there, how do we get there.</p>\r\n" + 
//        		"      <p>MS. EASTON: Well, Dr. Epps, we thank you for your service, for your curiosity and we wish you all the best in\r\n" + 
//        		"        the next exciting chapter of your life. (Applause.)</p>\r\n" + 
//        		"      <p>Thank you all for joining us. This has been a terrific evening. Safe travels.</p>\r\n" + 
//        		"      <p>(END)</p>";
//        
//        
//       api.getTransResult(query, "auto", "zh");
//    	
//    
//    	
//      	
//    }
//    
//    
// 
//
//}

**Part1 Bugs**

1. 
Buggy code
```
static void BugreverseInPlace(int[] arr) {
    for(int i = 0; i < arr.length; i += 1) {
        arr[i] = arr[arr.length - i - 1];
    }
}
```
Failure-inducing input
```
@Test 
public void testBugreverseInPlace() {
int[] input1 = { 3,2,1 };
ArrayBugExamples.BugreverseInPlace(input1);
assertArrayEquals(new int[]{ 1,2,3 }, input1);
}
```


2.  
Input that doesn't induce failure
```
@Test 
public void testBugPassreverseInPlace() {
int[] input1 = { 3,2,1 };
ArrayBugExamples.BugreverseInPlace(input1);
assertArrayEquals(new int[]{ 1,2,1 }, input1);
}
```
3. 


screenshot1: ![BugTest](Bugtests.PNG)


The bug, as the before-and-after code change required to fix it (as two code blocks in Markdown).
Briefly describe (2-3 sentences) why the fix addresses the issue.

4. 

Before code
```
static void BugreverseInPlace(int[] arr) {
    for(int i = 0; i < arr.length; i += 1) {
        arr[i] = arr[arr.length - i - 1];
    }
}
```

After code
```
static void reverseInPlace(int[] arr) {
    int[] duplicateArray = new int[arr.length];
    for(int i =0; i<arr.length;i+=1)
      duplicateArray[i] = arr[i];
    for(int i = 0; i < arr.length; i += 1) {
      arr[i] = duplicateArray[arr.length - i - 1];
    }
  }
```
The initial code for `BugreverseInPlace` attempts to reverse an `array` in place but incorrectly `overwrites` the `elements` during the `iteration`, leading to incorrect results as the `array` is modified while it's being used for assignments. The corrected `reverseInPlace` function resolves this by first copying the `original array` `elements` into a `duplicate array`, which safely stores the `original values`. Then, it uses this `duplicate array` to correctly assign the `reversed values` back to the `original array`, ensuring that the reversal is accurately achieved without unintended `overwrites`.

**Part2 Researching Commands**

1. Option `-i` (Ignore Case)
The `-i` option makes the search `case-insensitive`, allowing me to search for a pattern without worrying about the case of the letters.In `chapter-1.txt`, I found ``lines` with `"weather"` and `"portland"` while ignoring the `case sensitiveness`.This is useful esepcially when I am looking for a word that I am unsure whether it is capitalized or not.


```
Jungwoo Park@DESKTOP-01K6007 MINGW64 ~/docsearch/technical/911report (main)
$ grep -i "weather" chapter-1.txt
    For those heading to an airport, weather conditions could not have been better for a safe and pleasant journey. Among the travelers were Mohamed Atta and Abdul Aziz al Omari, who arrived at the airport in Portland, Maine.
```
```
$ grep -i "portland" chapter-1.txt
    For those heading to an airport, weather conditions could not have been better for a safe and pleasant journey. Among the travelers were Mohamed Atta and Abdul Aziz al Omari, who arrived at the airport in Portland, Maine.
    Boston: American 11 and United 175. Atta and Omari boarded a 6:00 A.M. flight from Portland to Boston's Logan International Airport.
    While Atta had been selected by CAPPS in Portland, three members of his hijacking team-Suqami, Wail al Shehri, and Waleed al Shehri-were selected in Boston. Their selection affected only the handling of their checked bags, not their screening at the checkpoint. All five men cleared the checkpoint and made their way to the gate for American 11. Atta, Omari, and Suqami took their seats in business class (seats 8D, 8G, and 10B, respectively). The Shehri brothers had adjacent seats in row 2 (Wail in 2A, Waleed in 2B), in the firstclass cabin. They boarded American 11 between 7:31 and 7:40. The aircraft pushed back from the gate at 7:40.
```


2. Option `-r` (recursive)

The `-r` option allows grep to perform a `recursive search`, examining all `files` under each `directory`, down through the entire `directory` tree.I used this to find "preface" and "bring" in `/technical/911report`. It was useful because I didn't have to go through all files in multiple directories to find `lines` containing these keywords.


```
Jungwoo Park@DESKTOP-01K6007 MINGW64 ~/docsearch/technical/911report (main)
$ grep -r "preface" 
chapter-13.3.txt:                For its preface, the Plan quoted a memo Tenet had sent to the CIA's senior
chapter-3.txt:                prefaced the directions with a message:"From the American President down to the
```
```
Jungwoo Park@DESKTOP-01K6007 MINGW64 ~/docsearch/technical/911report (main)
$ grep -r "bring"
chapter-1.txt:    Center: Hold on a second. I'm trying to bring him up here and get you-There he is right there. Hold on.
chapter-11.txt:                bring them back to the United States to stand trial for their crimes.
chapter-11.txt:                encouraged, and what capabilities they were bringing together for future assaults.
chapter-11.txt:                were not able to bring about significant improvements before leaving office. The
chapter-11.txt:                NSC-led interagency process did not effectively bring along the leadership of the
chapter-11.txt:                an alert Customs agent caught Ahmed Ressam bringing explosives across the Canadian
chapter-12.txt:                among ethnic communities. Yet even if his efforts are successful and elections bring
chapter-13.1.txt:                across the agencies (foreign or domestic), track progress, and quickly bring
chapter-13.1.txt:                    resolve differences in priorities among the agencies and bring the major
chapter-13.1.txt:                    to bring the major national security institutions into the information
chapter-13.3.txt:                continue to bring on board more linguists, it must also continue to take advantage
chapter-13.3.txt:                company sought to work with all Afghan factions to bring about the necessary
chapter-13.3.txt:                a decision had been made at this point on where to bring Bin Ladin.
chapter-13.3.txt:                demarche, including a warning that future attacks would bring "severe consequences."
chapter-13.3.txt:                designated a "foreign terrorist organization" also brings sanctions and stigmatizes
chapter-13.4.txt:                Sept. 15, 2003). On the problems with having Americans bring firearms into the
chapter-13.4.txt:                apartment when one of the guests created an awkward social circumstance by bringing
chapter-13.4.txt:                he would bring to the United States. He declared $35,000 upon arrival on February
chapter-2.txt:                destroy America and bring the world to Islam.
chapter-2.txt:                President Bush observed." Islam is a faith that brings comfort to a billion people
chapter-2.txt:                Taliban movement, espousing a ruthless version of Islamic law, perhaps could bring
chapter-3.txt:                extent of the new threat facing the United States. The trials did not bring the Bin
chapter-3.txt:                MAXCAP 05, was unveiled in 2000: it set the goal of bringing the Bureau to its
chapter-3.txt:                significant debate. The INS had immigration law expertise and authority to bring the
chapter-3.txt:                rejected efforts to bring additional resources to bear in the north. The border with
chapter-3.txt:                failed to bring to completion two efforts that would have provided inspectors with
chapter-3.txt:                study, and experience to bring a recruit up to full performance.
chapter-3.txt:                to protect sources, methods, and operations. The CIA must bring presidentially
chapter-3.txt:                Intelligence took the unprecedented step of threatening to bring down the defense
chapter-3.txt:                bringing him to the United States only to see him acquitted.
chapter-3.txt:                over three time zones, even bringing in personnel from the region. The FBI also
chapter-3.txt:                while he is in Afghanistan and bring him to justice."
chapter-3.txt:                Ladin, whom they had been trying to capture and bring to trial. Documents at the
chapter-3.txt:                deputies and bring them to trial; efforts to dry up Bin Ladin's money supply; and
chapter-3.txt:                aggressive." The future, they warned, might bring "horrific attacks," in which case
chapter-3.txt:            After flying to Nairobi and bringing home the coffins of the American dead, Secretary
chapter-3.txt:                the Northern Alliance, even though doing so might bring the United States squarely
chapter-5.txt:                earlier. Nibras and Quso were bringing Khallad money from Yemen, but were stopped in
chapter-6.txt:            Then, on December 14, an Algerian jihadist was caught bringing a load of explosives
chapter-6.txt:                period. Given that a presidential election in the United States brings wholesale
chapter-6.txt:                months were mainly spent organizing the effort and bringing an admiral from the
chapter-6.txt:                policy, he and Powell were bringing the State Department to a policy of overthrowing
chapter-6.txt:                the United States' ability to deliver Bin Ladin and bring him to justice. He favored
chapter-8.txt:                    "bring the fighting to America." After US missile strikes on his base in
chapter-9.txt:                primarily one of rescue. They called for a fifth alarm, which would bring additional
chapter-9.txt:                second Level 4 mobilization, bringing the total number of NYPD officers responding
```


3. Option `-v` (Invert Match)
The `-v` option inverts the match, showing only the `lines` that do not match the pattern. I found `lines` in `preface.txt` that do not contain `"enemy"` and `"important"`. This is useful when I need to find lines that have `errors` and I want to isolate them. 


```
Jungwoo Park@DESKTOP-01K6007 MINGW64 ~/docsearch/technical/911report (main)
$ grep -v "enemy" preface.txt

    

            PREFACE
            We present the narrative of this report and the recommendations that flow from it to
                the President of the United States, the United States Congress, and the American
                people for their consideration. Ten Commissioners-five Republicans and five
                Democrats chosen by elected leaders from our nation's capital at a time of great
                partisan division-have come together to present this report without dissent.
            We have come together with a unity of purpose because our nation demands it.
                September 11, 2001, was a day of unprecedented shock and suffering in the history of
                the United States. The nation was unprepared. How did this happen, and how can we
                avoid such tragedy again?
            To answer these questions, the Congress and the President created the National
                Commission on Terrorist Attacks Upon the United States (Public Law 107-306, November
                27, 2002).
            Our mandate was sweeping. The law directed us to investigate "facts and circumstances
                relating to the terrorist attacks of September 11, 2001," including those relating
                to intelligence agencies, law enforcement agencies, diplomacy, immigration issues
                and border control, the flow of assets to terrorist organizations, commercial
                aviation, the role of congressional oversight and resource allocation, and other
                areas determined relevant by the Commission. In pursuing our mandate, we have
                reviewed more than 2.5 million pages of documents and interviewed more than 1,200
                individuals in ten countries. This included nearly every senior official from the
                current and previous administrations who had responsibility for topics covered in
                our mandate. We have sought to be independent, impartial, thorough, and nonpartisan.
                From the outset, we have been committed to share as much of our investigation as we
                can with the American people. To that end, we held 19 days of hearings and took
                public testimony from 160 witnesses.
            Our aim has not been to assign individual blame. Our aim has been to provide the
                fullest possible account of the events surrounding 9/11 and to identify lessons
                learned.
                political grievances, but its hostility toward us and our values is limitless. Its
                purpose is to rid the world of religious and political pluralism, the plebiscite,
                and equal rights for women. It makes no distinction between military and civilian
                targets. Collateral damage is not in its lexicon.
            We learned that the institutions charged with protecting our borders, civil aviation,
                and national security did not understand how grave this threat could be, and did not
                adjust their policies, plans, and practices to deter or defeat it. We learned of
                fault lines within our government-between foreign and domestic intelligence, and
                between and within agencies. We learned of the pervasive problems of managing and
                sharing information across a large and unwieldy government that had been built in a
                different era to confront different dangers.
            At the outset of our work, we said we were looking backward in order to look forward.
                We hope that the terrible losses chronicled in this report can create something
                positive-an America that is safer, stronger, and wiser. That September day, we came
                together as a nation. The test before us is to sustain that unity of purpose and
                meet the challenges now confronting us. We need to design a balanced strategy for
                the long haul, to attack terrorists and prevent their ranks from swelling while at
                the same time protecting our country against future attacks. We have been forced to
                think about the way our government is organized. The massive departments and
                agencies that prevailed in the great struggles of the twentieth century must work
                together in new ways, so that all the instruments of national power can be combined.
                Congress needs dramatic change as well to strengthen oversight and focus
                accountability.
            As we complete our final report, we want to begin by thanking our fellow
                Commissioners, whose dedication to this task has been profound. We have reasoned
                together over every page, and the report has benefited from this remarkable
                dialogue. We want to express our considerable respect for the intellect and judgment
                of our colleagues, as well as our great affection for them.
            We want to thank the Commission staff. The dedicated professional staff, headed by
                Philip Zelikow, has contributed innumerable hours to the completion of this report,
                setting aside other important endeavors to take on this all-consuming assignment.
                They have conducted the exacting investigative work upon which the Commission has
                built. They have given good advice, and faithfully carried out our guidance. They
                have been superb. We thank the Congress and the President. Executive branch agencies
                have searched records and produced a multitude of documents for us. We thank
                officials, past and present, who were generous with their time and provided us with
                insight. The PENTTBOM team at the FBI, the Director's Review Group at the CIA, and
                Inspectors General at the Department of Justice and the CIA provided great
                assistance. We owe a huge debt to their investigative labors, painstaking attention
                to detail, and readiness to share what they have learned. We have built on the work
                of several previous Commissions, and we thank the Congressional Joint Inquiry, whose
                fine work helped us get started. We thank the City of New York for assistance with
                documents and witnesses, and the Government Printing Office and W.W. Norton
                & Company for helping to get this report to the broad public.
            We conclude this list of thanks by coming full circle: We thank the families of 9/11,
                whose persistence and dedication helped create the Commission. They have been with
                us each step of the way, as partners and witnesses. They know better than any of us
                the importance of the work we have undertaken.
            We want to note what we have done, and not done. We have endeavored to provide the
                most complete account we can of the events of September 11, what happened and why.
                This final report is only a summary of what we have done, citing only a fraction of
                the sources we have consulted. But in an event of this scale, touching so many
                issues and organizations, we are conscious of our limits. We have not interviewed
                every knowledgeable person or found every relevant piece of paper. New information
                inevitably will come to light. We present this report as a foundation for a better
                understanding of a landmark in the history of our nation.
            We have listened to scores of overwhelming personal tragedies and astounding acts of
                heroism and bravery. We have examined the staggering impact of the events of 9/11 on
                the American people and their amazing resilience and courage as they fought back. We
                have admired their determination to do their best to prevent another tragedy while
                preparing to respond if it becomes necessary. We emerge from this investigation with
                enormous sympathy for the victims and their loved ones, and with enhanced respect
                for the American people. We recognize the formidable challenges that lie ahead.
            We also approach the task of recommendations with humility. We have made a limited
                number of them. We decided consciously to focus on recommendations we believe to be
                most important, whose implementation can make the greatest difference. We came into
                this process with strong opinions about what would work. All of us have had to
                pause, reflect, and sometimes change our minds as we studied these problems and
                considered the views of others. We hope our report will encourage our fellow
                citizens to study, reflect-and act.
            Thomas H. Kean, chair
            Lee H. Hamilton, vice chair
```

```
$ grep -v "important" preface.txt

    

            PREFACE
            We present the narrative of this report and the recommendations that flow from it to
                the President of the United States, the United States Congress, and the American
                people for their consideration. Ten Commissioners-five Republicans and five
                Democrats chosen by elected leaders from our nation's capital at a time of great
                partisan division-have come together to present this report without dissent.
            We have come together with a unity of purpose because our nation demands it.
                September 11, 2001, was a day of unprecedented shock and suffering in the history of
                the United States. The nation was unprepared. How did this happen, and how can we
                avoid such tragedy again?
            To answer these questions, the Congress and the President created the National
                Commission on Terrorist Attacks Upon the United States (Public Law 107-306, November
                27, 2002).
            Our mandate was sweeping. The law directed us to investigate "facts and circumstances
                relating to the terrorist attacks of September 11, 2001," including those relating
                to intelligence agencies, law enforcement agencies, diplomacy, immigration issues
                and border control, the flow of assets to terrorist organizations, commercial
                aviation, the role of congressional oversight and resource allocation, and other
                areas determined relevant by the Commission. In pursuing our mandate, we have
                reviewed more than 2.5 million pages of documents and interviewed more than 1,200
                individuals in ten countries. This included nearly every senior official from the
                current and previous administrations who had responsibility for topics covered in
                our mandate. We have sought to be independent, impartial, thorough, and nonpartisan.
                From the outset, we have been committed to share as much of our investigation as we
                can with the American people. To that end, we held 19 days of hearings and took
                public testimony from 160 witnesses.
            Our aim has not been to assign individual blame. Our aim has been to provide the
                fullest possible account of the events surrounding 9/11 and to identify lessons
                learned.
            We learned about an enemy who is sophisticated, patient, disciplined, and lethal. The
                enemy rallies broad support in the Arab and Muslim world by demanding redress of
                political grievances, but its hostility toward us and our values is limitless. Its
                purpose is to rid the world of religious and political pluralism, the plebiscite,
                and equal rights for women. It makes no distinction between military and civilian
                targets. Collateral damage is not in its lexicon.
            We learned that the institutions charged with protecting our borders, civil aviation,
                and national security did not understand how grave this threat could be, and did not
                adjust their policies, plans, and practices to deter or defeat it. We learned of
                fault lines within our government-between foreign and domestic intelligence, and
                between and within agencies. We learned of the pervasive problems of managing and
                sharing information across a large and unwieldy government that had been built in a
                different era to confront different dangers.
            At the outset of our work, we said we were looking backward in order to look forward.
                We hope that the terrible losses chronicled in this report can create something
                positive-an America that is safer, stronger, and wiser. That September day, we came
                together as a nation. The test before us is to sustain that unity of purpose and
                meet the challenges now confronting us. We need to design a balanced strategy for
                the long haul, to attack terrorists and prevent their ranks from swelling while at
                the same time protecting our country against future attacks. We have been forced to
                think about the way our government is organized. The massive departments and
                agencies that prevailed in the great struggles of the twentieth century must work
                together in new ways, so that all the instruments of national power can be combined.
                Congress needs dramatic change as well to strengthen oversight and focus
                accountability.
            As we complete our final report, we want to begin by thanking our fellow
                Commissioners, whose dedication to this task has been profound. We have reasoned
                together over every page, and the report has benefited from this remarkable
                dialogue. We want to express our considerable respect for the intellect and judgment
                of our colleagues, as well as our great affection for them.
            We want to thank the Commission staff. The dedicated professional staff, headed by
                Philip Zelikow, has contributed innumerable hours to the completion of this report,
                They have conducted the exacting investigative work upon which the Commission has
                built. They have given good advice, and faithfully carried out our guidance. They
                have been superb. We thank the Congress and the President. Executive branch agencies
                have searched records and produced a multitude of documents for us. We thank
                officials, past and present, who were generous with their time and provided us with
                insight. The PENTTBOM team at the FBI, the Director's Review Group at the CIA, and
                Inspectors General at the Department of Justice and the CIA provided great
                assistance. We owe a huge debt to their investigative labors, painstaking attention
                to detail, and readiness to share what they have learned. We have built on the work
                of several previous Commissions, and we thank the Congressional Joint Inquiry, whose
                fine work helped us get started. We thank the City of New York for assistance with
                documents and witnesses, and the Government Printing Office and W.W. Norton
                & Company for helping to get this report to the broad public.
            We conclude this list of thanks by coming full circle: We thank the families of 9/11,
                whose persistence and dedication helped create the Commission. They have been with
                us each step of the way, as partners and witnesses. They know better than any of us
                the importance of the work we have undertaken.
            We want to note what we have done, and not done. We have endeavored to provide the
                most complete account we can of the events of September 11, what happened and why.
                This final report is only a summary of what we have done, citing only a fraction of
                the sources we have consulted. But in an event of this scale, touching so many
                issues and organizations, we are conscious of our limits. We have not interviewed
                every knowledgeable person or found every relevant piece of paper. New information
                inevitably will come to light. We present this report as a foundation for a better
                understanding of a landmark in the history of our nation.
            We have listened to scores of overwhelming personal tragedies and astounding acts of
                heroism and bravery. We have examined the staggering impact of the events of 9/11 on
                the American people and their amazing resilience and courage as they fought back. We
                have admired their determination to do their best to prevent another tragedy while
                preparing to respond if it becomes necessary. We emerge from this investigation with
                enormous sympathy for the victims and their loved ones, and with enhanced respect
                for the American people. We recognize the formidable challenges that lie ahead.
            We also approach the task of recommendations with humility. We have made a limited
                number of them. We decided consciously to focus on recommendations we believe to be
                this process with strong opinions about what would work. All of us have had to
                pause, reflect, and sometimes change our minds as we studied these problems and
                considered the views of others. We hope our report will encourage our fellow
                citizens to study, reflect-and act.
            Thomas H. Kean, chair
            Lee H. Hamilton, vice chair
```

4. Option `-n` (Line numbers)
The `-n` option adds `line numbering` to the search results, which provides the `line numbers` from the original file where each match is found. I found `lines` that contain `"60"` and `"PDTC"` in `technical/biomed/1471-230X-1-5.txt`
This is particularly useful for debugging code, analyzing logs, or any scenario where you need to know exactly where in a file something occurs. 


```
Jungwoo Park@DESKTOP-01K6007 MINGW64 ~/docsearch/technical/biomed (main)
$ grep -n "60" 1471-230X-1-5.txt
6:        MAdCAM-1 is a 60 kD endothelial cell adhesion molecule
84:          were pre-treated for 60 minutes prior to incubation.
138:          by scanning the 60 kD band, using a HP ScanJet™ flatbed
171:          MA) at 37°C for 60 min. The cells were then washed twice
285:        propria involves a single-chain 60-Kd adhesion
```
```
Jungwoo Park@DESKTOP-01K6007 MINGW64 ~/docsearch/technical/biomed (main)
$ grep -n "PDTC" 1471-230X-1-5.txt
29:        prevented by antioxidants like PDTC or NAC.
```

Source for the command options: <https://www.geeksforgeeks.org/grep-command-in-unixlinux/>

/***********************************************
 * 
 * The is a service class for messages
 * for custom messaging protocol using
 * https, it's the alternative mailing
 * utility to mailing utility by mail
 * service MailService.java
 * 
 * @author Okuonzi Hilary
 * @date 31st May, 2025
 * @file MessageService.java
 * @version 1.0
 * 
 */

package com.Mailer.MailChat.services;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
// import java.util.stream.Collectors;

import com.Mailer.MailChat.model.MessageModal;

public class MessageService {
    // private List<Message> messages = new ArrayList<>();
    private List<MessageModal> testMessages = new ArrayList<>();

    public void sendMessage(MessageModal msg) {
        msg.setTimestamp(LocalDateTime.now());
        msg.setFolder("Sent");
        testMessages.add(msg);
        saveToDisk(); // This is incomplete
    }

    public List<MessageModal> getMessages(String folder) {
        testMessages.add(new MessageModal(
                "ceo@openai.com",
                "professor@example.com",
                "Meeting Follow-Up",
                "Hi,\n\nThanks for the insightful discussion today. I've attached the summary report and timeline.\n\nBest,\nSam",
                LocalDateTime.of(2025, 6, 1, 14, 45),
                "Inbox"));

        testMessages.add(new MessageModal(
                "hr@globaltech.com",
                "you@example.com",
                "Job Application Update",
                "Dear Applicant,\n\nWe appreciate your interest. You have moved to the next phase of the interview process.\n\nRegards,\nGlobalTech HR",
                LocalDateTime.of(2025, 5, 28, 10, 30),
                "Inbox"));

        testMessages.add(new MessageModal(
                "events@mozillacorp.org",
                "devteam@example.com,qa@example.com,admin@example.com",
                "Hackathon Invite: June 2025",
                "You're invited to the Mozilla Open Hack 2025. Build, collaborate, win!",
                LocalDateTime.of(2025, 5, 26, 9, 0),
                "Sent"));

        testMessages.add(new MessageModal(
                "news@aiweekly.org",
                "subscriber@example.com",
                "AI Weekly #202",
                "🚀 This week in AI:\n- GPT-6 leaks\n- NVIDIA breaks records\n- Ethics in synthetic media\n\nRead more inside.",
                LocalDateTime.of(2025, 5, 30, 7, 45),
                "Inbox"));

        testMessages.add(new MessageModal(
                "editor@openjournal.org",
                "alec.researcher@example.com",
                "Manuscript Review Decision - OJCS-2025-0178",
                "Dear Alec,\n\nThank you for submitting your manuscript titled *'Quantum Entanglement in Data Privacy Models'* to the Open Journal of Computer Science. After careful review, we regret to inform you that your submission has not been accepted for publication at this time.\n\nWhile the reviewers acknowledged the potential significance of your findings, they also highlighted several areas requiring further elaboration, particularly in your proposed entropy correction algorithm.\n\nYou are welcome to revise and resubmit in the future. We appreciate your interest in our journal and encourage you to continue contributing to the field.\n\nSincerely,\nDr. Mariana Voss\nEditor-in-Chief",
                LocalDateTime.of(2025, 5, 29, 11, 22),
                "Inbox"));

        testMessages.add(new MessageModal(
                "ceo@chiefalry.com",
                "team@chiefalry.com",
                "📢 Quarterly Vision & Milestones",
                "Team,\n\nThis quarter has been transformative. From the rollout of SeramaZone’s beta to the integration of Rust APIs in our backend, we've hit critical milestones that will shape our direction in Q4 and beyond.\n\nNext steps involve improving onboarding UX, doubling down on vendor acquisition, and refining the payments module. Our Uganda pilot is gaining traction—expect a field trip calendar soon.\n\nKeep shipping with honor and grit. Your work is building history.\n\nBaron-in-Chief,\nAlec",
                LocalDateTime.of(2025, 6, 1, 8, 0),
                "Inbox"));

        testMessages.add(new MessageModal(
                "heather.nyeko@ecofarms.org",
                "alec@researchhub.org",
                "RE: Climate Impact Report Draft",
                "Hi Alec,\n\nI reviewed your latest draft of the Climate Impact report. The section on Lake Victoria's microclimates was exceptionally insightful, especially your simulation results from the Rust-based model. That kind of data is missing in most NGO briefs.\n\nA few things to consider: Add a visualization for the yield comparison, reword the third paragraph in the conclusion to sound less deterministic, and check if FAO 2025 data is public yet.\n\nLet’s finalize the report by Friday so it’s ready for the regional summit.\n\nBest,\nHeather",
                LocalDateTime.of(2025, 5, 28, 15, 40),
                "Important"));

        testMessages.add(new MessageModal(
                "diana.m@leapdesigns.com",
                "alec@devstudio.com",
                "Website UI Audit & Suggestions",
                "Hi Alec,\n\nAttached is my UX/UI audit for the Chiefalry blog and product discovery pages. You've got a solid foundation, but there are consistency issues in the nav bar across mobile breakpoints.\n\nI recommend replacing Bootstrap’s grid in a few places with CSS Grid for better reflow. Also, consider using a muted alpha layer behind the reels section to improve visibility across themes.\n\nLet me know if you want us to jump on a Figma session this week.",
                LocalDateTime.of(2025, 5, 27, 10, 20),
                "Inbox"));

        testMessages.add(new MessageModal(
                "karen@springcapital.africa",
                "alec@chiefalry.com",
                "Follow-Up: Series A Interest",
                "Dear Alec,\n\nThank you for presenting Chiefalry's vision during the Nairobi Founders’ Forum. We’re impressed by the platform’s scope and your grasp of cross-sector e-commerce dynamics, especially with localized service marketplaces.\n\nSpring Capital is currently reviewing candidates for our Q3 seed-to-Series-A cohort. We’ll need a more detailed cap table, revenue projections post-beta, and an outline of your onboarding strategy for new vendors.\n\nIf agreeable, let’s set up a diligence call early next week.\n\nWarm regards,\nKaren",
                LocalDateTime.of(2025, 5, 30, 13, 0),
                "Important"));

        testMessages.add(new MessageModal(
                "no-reply@banksecure.com",
                "them@example.com",
                "Unusual Activity Detected!",
                "Alert: A login attempt from Lagos, Nigeria was blocked. Was this you?\n\nIf not, reset your password immediately.",
                LocalDateTime.of(2025, 5, 30, 3, 17),
                "Sent"));

        testMessages.add(new MessageModal(
                "dr.rashid@mak.ac.ug",
                "alec@univmail.org",
                "Field Study Extension Approval",
                "Dear Mr. Alec,\n\nThis is to confirm that your request for a two-week extension for the Wetlands Impact Field Study has been approved. Kindly ensure that your supervising TA updates the revised schedule on the department portal.\n\nPlease note that the extended submission date will be June 15, 2025. Failure to submit by that date may result in forfeiture of credit for the module.\n\nAll the best in your continued research.\n\nRegards,\nDr. Rashid Wakabi\nField Studies Coordinator",
                LocalDateTime.of(2025, 5, 26, 9, 30),
                "Inbox"));

        testMessages.add(new MessageModal(
                "helen@gracemedia.net",
                "me@example.com",
                "Script Feedback: 'Fragments of Time'",
                "Hey!\n\nI finally got around to reading *Fragments of Time* last night. Wow—some of those monologues hit hard, especially in Act 2. There’s a quiet depth to the pacing that reminds me of Orwell mixed with Baldwin.\n\nOne suggestion: tighten the third scene—cut 10% of the dialogue. It drags slightly, even though the core ideas are strong. Also, that part where the protagonist stares into the mirror... could use a symbolic prop to bring the tension home.\n\nExcited to see this live someday.\n\n—Helen",
                LocalDateTime.of(2025, 6, 1, 00, 17),
                "Inbox"));

        testMessages.add(new MessageModal(
                "scamnet@millionmagic.biz",
                "victim@example.com",
                "You’ve Won a Tesla Model X!",
                "Congrats! You just won a Tesla. Just pay the $99 processing fee via crypto to claim.\nAct now!",
                LocalDateTime.of(2025, 5, 25, 21, 13),
                "Spam"));

        testMessages.add(new MessageModal(
                "notifications@codehub.dev",
                "you@example.com",
                "New PR Request on Project-AI",
                "You've received a pull request from 'contributorguy' to review.\n\nDiff: 23 additions, 7 deletions.",
                LocalDateTime.of(2025, 5, 27, 12, 0),
                "Inbox"));

        testMessages.add(new MessageModal(
                "susan@example.com",
                "me@example.com",
                "Dinner plans?",
                "Hey! Are we still on for dinner tomorrow night at Blue Fig? Let me know!\n\n❤️ Susan",
                LocalDateTime.of(2025, 5, 29, 18, 0),
                "Inbox"));

        testMessages.add(new MessageModal(
                "admin@chiefalry.com",
                "bob@example.com,zoe@example.com",
                "Server Downtime Notification",
                "⚠️ The backend servers will be down for maintenance from 2 AM to 6 AM UTC. Please plan accordingly.",
                LocalDateTime.of(2025, 5, 30, 22, 0),
                "Important"));

        testMessages.add(new MessageModal(
                "newsletter@startupdaily.io",
                "me@example.com",
                "Top 5 African Startups to Watch in 2025",
                "Discover the next unicorns of Africa, and why investors are turning East.\n\n- Team Startup Daily",
                LocalDateTime.of(2025, 5, 30, 10, 0),
                "Inbox"));

        testMessages.add(new MessageModal(
                "researchgroup@mit.edu",
                "professor@example.com",
                "Quantum AI Research Draft v3",
                "Hi Prof,\n\nAttached is the third draft of the Quantum-AI integration paper. Feedback welcome!\n\nRegards,\nAnika",
                LocalDateTime.of(2025, 5, 30, 11, 55),
                "Sent"));

        testMessages.add(new MessageModal(
                "me@example.com",
                "info@chiefalry.com",
                "Request for Service Demo",
                "Hello,\n\nCould I schedule a demo for the Chiefalry vendor interface sometime next week?\n\nThanks!",
                LocalDateTime.of(2025, 5, 31, 15, 22),
                "Sent"));

        testMessages.add(new MessageModal(
                "noreply@udemy.com",
                "you@example.com",
                "🎓 Course Completion Certificate",
                "Congrats! You've completed 'Rust for Backend Development'.\nDownload your certificate below:\nhttps://udemy.com/cert/abc123",
                LocalDateTime.of(2025, 5, 29, 16, 30),
                "Inbox"));

        testMessages.add(new MessageModal(
                "legal@paypal.com",
                "you@example.com",
                "Account Policy Violation",
                "We've detected multiple chargebacks on your account. Please review our Acceptable Use Policy here: paypal.com/legal.",
                LocalDateTime.of(2025, 5, 24, 14, 18),
                "Inbox"));

        testMessages.add(new MessageModal(
                "team@notion.so",
                "me@example.com",
                "Your Workspace Backup is Ready",
                "Download your May 2025 workspace backup using this secure link. It will expire in 7 days.",
                LocalDateTime.of(2025, 5, 30, 5, 45),
                "Archive"));

        testMessages.add(new MessageModal(
                "research@harvard.edu",
                "prof.alec@example.com",
                "Call for Papers: AI and Ethics 2025",
                "Dear Prof. Alec,\n\nWe invite submissions for the upcoming AI & Ethics 2025 conference. Please submit abstracts by October 1st, 2025.\n\nBest regards,\nHarvard Research Committee",
                LocalDateTime.of(2025, 7, 14, 10, 5),
                "Inbox"));

        testMessages.add(new MessageModal(
                "client@westwoodcorp.com",
                "me@example.com",
                "Re: Invoice Clarification Needed",
                "Hi,\n\nCould you clarify the service fees on invoice #7734? I believe there's a double charge.\n\nThanks,\nWestwood Finance Dept.",
                LocalDateTime.of(2025, 6, 21, 16, 42),
                "Important"));

        testMessages.add(new MessageModal(
                "rachel@funmail.com",
                "derek@example.com,joy@example.com,sasha@example.com",
                "🎉 Karaoke Night Friday!",
                "Hey friends!\n\nWe’re hitting up Melody Lounge this Friday. Warm up those vocal cords! RSVP by Thursday night.\n\n💃🕺\n-Rach",
                LocalDateTime.of(2025, 6, 2, 18, 10),
                "Sent"));

        testMessages.add(new MessageModal(
                "fake.bank.alerts@fraudmail.ru",
                "you@example.com",
                "⚠️ Account Compromised!",
                "Your account has been hacked. Click the link to secure it:\n\nhttp://totally-legit-bank-login.ru/secure\n\nHurry before it's too late!",
                LocalDateTime.of(2025, 5, 31, 23, 59),
                "Spam"));

        testMessages.add(new MessageModal(
                "janet@careershub.org",
                "hr@example.com",
                "Job Reference Request: Michael Lang",
                "Dear HR,\n\nMichael Lang listed your company as a reference. Could you provide a quick note on his performance?\n\nThanks,\nJanet\nRecruitment Officer",
                LocalDateTime.of(2025, 6, 1, 9, 45),
                "Inbox"));

        // return
        // messages.stream().filter(m->m.getFolder().equals(folder)).collect(Collectors.toList());
        return testMessages;
    }

    private void saveToDisk() {
        // NOTE: saveToDisk() to be implemented with database
        System.out.println("Save to disk triggered, yet to be implemented!");
    }

    @SuppressWarnings("unused")
    private void loadFromDisk() {
        // NOTE: loadFromDisk() to be implemented with database
    }
}

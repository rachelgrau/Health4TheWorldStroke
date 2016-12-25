package com.example.rachel.health4theworldstroke.Activities;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.rachel.health4theworldstroke.R;

import static com.example.rachel.health4theworldstroke.Activities.InfoListActivity.EXTRA_INFO_TYPE;
import static com.example.rachel.health4theworldstroke.Activities.InfoListActivity.INFO_TYPE_ABOUT_US;
import static com.example.rachel.health4theworldstroke.Activities.InfoListActivity.INFO_TYPE_COPYRIGHT;
import static com.example.rachel.health4theworldstroke.Activities.InfoListActivity.INFO_TYPE_PRIVACY_POLICY;
import static com.example.rachel.health4theworldstroke.Activities.InfoListActivity.INFO_TYPE_TERMS;

public class InfoActivity extends AppCompatActivity {
    private String title = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        this.title = this.getIntent().getExtras().getString(EXTRA_INFO_TYPE);
        setUpToolbar();
        setUpText();
    }

    /* Sets up the top toolbar. */
    private void setUpToolbar() {
        Toolbar myToolbar = (Toolbar) findViewById(R.id.info_toolbar);
        myToolbar.setTitle("");
        Typeface font = Typeface.createFromAsset(getAssets(), "Roboto-Light.ttf");
        TextView toolbarTitle = (TextView) myToolbar.findViewById(R.id.toolbar_title);
        toolbarTitle.setText(this.title);
        toolbarTitle.setTypeface(font);
        setSupportActionBar(myToolbar);
    }

    private void setUpText() {
        if (this.title.equals(INFO_TYPE_ABOUT_US)) {
            setUpAboutUs();
        } else if (this.title.equals(INFO_TYPE_TERMS)) {
            setUpTerms();
        } else if (this.title.equals(INFO_TYPE_PRIVACY_POLICY)) {
            setUpPrivacyPolicy();
        } else if (this.title.equals(INFO_TYPE_COPYRIGHT)) {
            setUpCopyright();
        }
    }

    public void addHeaderWithText(String text) {
        LinearLayout ll = (LinearLayout) findViewById(R.id.text_linear_layout);
        TextView textView = new TextView(this);
        textView.setTypeface(null, Typeface.BOLD);
        textView.setText(text);
        textView.setPadding(40, 40, 40, 10);
        textView.setTextSize(20);
        textView.setBackgroundColor(Color.WHITE);
        ll.addView(textView);
    }

    public void addSubheaderWithText(String text) {
        LinearLayout ll = (LinearLayout) findViewById(R.id.text_linear_layout);
        TextView textView = new TextView(this);
        textView.setTypeface(null, Typeface.BOLD);
        textView.setText(text);
        textView.setTypeface(Typeface.DEFAULT_BOLD);
        textView.setPadding(40, 10, 40, 0);
        textView.setTextSize(16);
        textView.setBackgroundColor(Color.WHITE);
        ll.addView(textView);
    }

    public void addTextViewWithText(String text) {
        LinearLayout ll = (LinearLayout) findViewById(R.id.text_linear_layout);
        TextView secondPar = new TextView(this);
        secondPar.setText(text);
        secondPar.setPadding(40, 10, 40, 0);
        secondPar.setTextSize(14);
        secondPar.setBackgroundColor(Color.WHITE);
        ll.addView(secondPar);
    }

    public void addIndentedTextViewWithText(String text) {
        LinearLayout ll = (LinearLayout) findViewById(R.id.text_linear_layout);
        TextView secondPar = new TextView(this);
        secondPar.setText(text);
        secondPar.setPadding(65, 10, 40, 0);
        secondPar.setTextSize(14);
        secondPar.setBackgroundColor(Color.WHITE);
        ll.addView(secondPar);
    }

    public void addLineBreak() {
        LinearLayout ll = (LinearLayout) findViewById(R.id.text_linear_layout);
        View line = new View(this);
        line.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 3));
        line.setBackgroundColor(ContextCompat.getColor(this, R.color.darkGray));
        ll.addView(line);
    }

    public void setUpAboutUs() {
        addHeaderWithText("Mobile App Introduction");
        addTextViewWithText("The HEALTH4THEWORLD STROKE HOPE APP is a free of cost educational tool to spread knowledge about stroke risk factors, secondary prevention, post stroke mobility & exercise education and speech strategies.  It has been created by Health4TheWorld which is a non profit organization inspired by the unmet medical needs worldwide. The mission of the organization is solving health inequities through innovation & technology and bringing smiles around the world. Please learn more about us at health4theworld.org.");
        addTextViewWithText("With an estimated incidence of 16.9 million and a prevalence of 33 million according to the World Health Organization, stroke is a dominant diseased entity in the category of cardiovascular diseases, and is a leading cause of serious long-term disability. The global burden of stroke falls disproportionately on low and middle-income countries, prompting us to improve global health educational outreach. We hope that this stroke educational app will be helpful.");
        addTextViewWithText("The app has several features that we hope you will find useful!");
        addIndentedTextViewWithText("• Stroke Educational Content – Information on causes and risk factors of stroke with guidelines from the American Stroke Association, American Heart Association, evidence based articles and other healthcare sources. It is good to remember that these are general educational tips and not recommendations for clinical care. Both the patient and trained health professionals should sit together to work on a personalized prevention regimen for stroke.");
        addIndentedTextViewWithText("• Video Animation and Exercise Tips for Stroke Recovery –Education for exercise and rehabilitation after stroke has been summarized by Physical Medicine and Rehabilitation experts from Stanford, University of California, San Francisco and University of Southern California. The exercises here are general and are intended to serve as educational guide not as medical advice.  These should be done with an occupational therapist and/or physical therapist, which can help with the correct technique and designing a regimen that will benefit a stroke patient best. A caregiver should always be present to help. These are divided into strengthening, stretching and functional mobility. Please advise your patients about the correct technique, frequency and regimen of these exercises.");
        addIndentedTextViewWithText("• Reminders for Medications and Appointments: Medication and Appointment compliance is a major issue and this tool is hopefully helpful!  Please set reminders for your patients if possible.");
        addIndentedTextViewWithText("• Speech Strategies After Stroke: The press button voice output can help with very basic communication. The aim is to translate these to different languages so health professions and patients in remote parts of the world who lack health access can benefit from these.");
        addTextViewWithText("THANK YOU.");
        addTextViewWithText("This application wouldn’t have been possible without work of a dream team!");
        addSubheaderWithText("Founders");
        addTextViewWithText("Dr. Bhavya Rehani, Dr. Bill Dillon & Dr. Ankur Bharija");
        addSubheaderWithText("Software engineer and developer of the app");
        addTextViewWithText("Rachel Grau");
        addSubheaderWithText("Animations");
        addTextViewWithText("by Ernesto Aguilar");
        addSubheaderWithText("Illustrations");
        addTextViewWithText("by Julie Kim, Bhavya Rehani, Ankur Bharija");
        addSubheaderWithText("Content Editing");
        addTextViewWithText("by Dr. Lilly Zhang, Isaiah Brown and Dr Bhavya Rehani");
        addSubheaderWithText("Movies");
        addTextViewWithText("by Jack McGill");
        addSubheaderWithText("Medical Advisory Board for the App");
        addTextViewWithText("Dr. Marc Fisher:  Dr Fisher currently serves as editor-in-chief of Stroke and Senior Physician on the Stroke Service at BIDMC, Harvard Medical School. He is well renowned and has published extensively over 260 peer-reviewed articles and has edited or co-edited 13 books.");
        addTextViewWithText("Dr. Jeffrey Teraoke: Dr. Teraoke is Chief, PM &R at Palo Alto VA Medical Center. He is the program director of PM&R Residency Program and Director, Polytrauma, VA Palo Alto Health System");
        addTextViewWithText("Dr. Erica A Pitsch, PT, MPT, DPT, NCS: Health Science Assistant Clinical Professor, UCSF. Dr. Pitsch specializes in neurologic physical therapy and uses several treatment strategies and approaches, all focused on promoting optimal challenge, function, and recovery in persons with neurologic illness");
        addTextViewWithText("Loren Ward, PT, DPT is licensed Physical Therapist who began her career in Physical Therapy in 2007, while earning her Doctorate at MGH Institute of Health Professions in Massachusetts. She did internships at Rehabilitation of Chicago, Spaulding Rehabilitation and National Rehabilitation Hospital and now works at Stanford Veteran’s Affairs System. Loren is an advocate of functional independence and strives to help her patients reach their own level of independence regardless of their limitations.");
        addTextViewWithText("Rose Hamm, PT, DPT, CWS, FACCWS: Rose received a BS in Physical Therapy from the University of North Carolina, Chapel Hill, and an MS and post-graduate DPT from the University of Southern California.  She is currently Adjunct Assistant Professor of Clinical Physical Therapy at the University of Southern California and practices at Keck Hospital at USC.");
    }

    public void setUpTerms() {
        addHeaderWithText("Thank you for using Health4TheWorld!");
        addLineBreak();
        addTextViewWithText("These terms and conditions of use (\"Terms\") are an agreement between Health4TheWorld (the “Health4TheWorld,” “we,” “us,” or “our”) and you (either you as an individual or the entity or organization on whose behalf you are entering into these terms and conditions) for access to and use of this website, which includes, media, documentation, pictures and other content, (collectively, the \"Website\"), as well as for access to and use of any products, services, and downloadable applications provided by Health4TheWorld (the “Services”). Please read these Terms carefully, and contact us at contact@health4theworld.org for any questions. Our Services also include downloadable applications, cloud-based applications, mobile and desktop applications, and applications in which our content is distributed via third-party sites.");
        addTextViewWithText("BY COPYING, DOWNLOADING OR OTHERWISE ACCESSING OR USING THE WEBSITE, APP OR SERVICES, YOU AGREE TO BE BOUND BY THESE TERMS, INCLUDING THE WARRANTY DISCLAIMERS AND LIMITATION OF LIABILITY PROVISIONS BELOW. IF YOU DO NOT UNDERSTAND OR AGREE TO THESE TERMS, DO NOT ACCESS OR USE THE WEBSITE OR SERVICES AND PLEASE EXIT THE WEBSITE NOW. ");
        addTextViewWithText("Health4TheWorld reserves the right to modify these Terms at any time without advance notice. Any changes to these Terms will be effective immediately upon posting on this page, with an updated effective date. By accessing the Website or Services after any changes have been made, you signify your agreement on to the modified Terms and all of the changes.");

        addHeaderWithText("Using Health4TheWorld");
        addLineBreak();
        addSubheaderWithText("Access to and Use of Website, mobile app and Services");
        addTextViewWithText("You may use our Website, Mobile application and Services only if you can form a binding contract with Health4TheWorld, and only in compliance with these Terms and all applicable laws. When retrieving information from the Website or Services, you are prohibited from (a) using or attempting to use spiders, robots, avatars, intelligent agents, or any other extraction or navigation search except for a normal browser, (b) aggregating, copying or duplicating any of the materials or information available from the Website or Services except for the small amount of materials and information temporarily required for an ordinary single use of the Website and/or Services, or (c) accessing data not intended for you. As a condition of your use or access of the Website and Services, you agree as follows:");
        addIndentedTextViewWithText("• Any use or access by anyone under the age of 13 is prohibited, and certain courses and materials provided on the Website and made available through the Services may have additional requirements and/or restrictions.");
        addIndentedTextViewWithText("• You shall provide us with accurate and complete information, and you agree to update your contact and account information and to keep it accurate and complete at all times.");
        addIndentedTextViewWithText("• You shall only access or use the Website or Services with a compatible device or computer. We assume no responsibility or liability for loss resulting from failure to comply with this provision.");
        addIndentedTextViewWithText("• You shall not use the Website or Services for any illegal or unauthorized purposes.");
        addIndentedTextViewWithText("• You shall not duplicate or resell the Services.");
        addIndentedTextViewWithText("• You shall not transmit worms, viruses or any code of a destructive nature to the Health4TheWorld, other users, the Website, or the Services.");
        addTextViewWithText("Any use of the Website or the Services in violation of the foregoing violates these Terms and may result in, among other things, termination or suspension of your rights to use the Website and the Services. We reserve the right to monitor your use of the Website and the Services to ensure your compliance with these Terms, or pursuant to a court, administrative, or governmental order. Furthermore, we reserve the right to deactivate or suspend your use of the Website or the Services for any reason. In addition to these Terms, your use of the Website and/or Services is governed by our Privacy Policy. You agree that Health4TheWorld’s collection, use and sharing of any personal information will be as set forth in the Privacy Policy, which may be amended by us from time to time. The Privacy Policy and any posted terms or guidelines are hereby incorporated by reference into these Terms.");
        addSubheaderWithText("Our License to You");
        addTextViewWithText("Subject to your compliance with these Terms and our policies (including the Acceptable Use Policy, Honor Code, Privacy Policy and other terms), we grant you a limited, personal, non-exclusive, non-transferable, and revocable license to use our Website and Services. You may download content from our Website and Services only for your personal, non-commercial use, unless you obtain Health4TheWorld's written permission to otherwise use the content. All other rights are reserved. You also agree that you will create, access, and/or use only one user account, and you will not share with any third party access to or access information for your account. In consideration of this license, you agree that: (a) any copy you make of the pages, data, text, images, audio, video, or other content within the Website, Mobile application or Services shall retain all copyright and other proprietary notices contained in such materials; and (b) any such materials shall distributed solely in accordance with these Terms. Notwithstanding the foregoing, you may not sell, transfer, share, license, or sublicense the Website, mobile application or Services to any third party and you may not use the Website, Mobile application or Services for the purpose of indirectly or directly competing with Health4TheWorld. Using our Website, Mobile application or Services does not give you ownership of any intellectual property rights therein or to the content you access.  Furthermore, as some of our Services may be software that is downloaded to your computer, phone, tablet, or other device, you agree that we may automatically update this software, and that these Terms will apply to such updates.");

        addHeaderWithText("Our Educational Content");
        addLineBreak();
        addSubheaderWithText("Content Modifications");
        addTextViewWithText("While we take pride in our world-class educational content, unexpected events do occur. Health4TheWorld reserves the right to cancel, interrupt, reschedule or modify any educational content or the point value or weight of any assignment, quiz, or other assessment. Offered educational contents are subject to the Disclaimers and Limitation of Liability sections below.");
        addSubheaderWithText("No Academic Credit");
        addTextViewWithText("Unless otherwise explicitly indicated by a credit-granting institution, participation in or completion of a course provided through our Website or Services does NOT confer any academic credit. Even if credit is awarded by one institution, there is no presumption that other institutions will accept that credit. You agree not to accept credit for completing a course through our Website or Services unless you have earned a Course Certificate (or other equivalent Health4TheWorld credential) for that course. Health4TheWorld, the course instructors, and the associated participating institutions have no obligation to have a course recognized by any educational institution or accreditation organization.");
        addSubheaderWithText("Disclaimer of Student-University Relationship");
        addTextViewWithText("Nothing in these Terms or otherwise with respect to your participation in any course: (a) establishes any relationship between you and any educational institution with which Health4TheWorld may be affiliated; (b) enrolls or registers you in any educational institution, or in any course offered by any educational institution; or (c) entitles you to use the resources of any educational institution beyond participation in the course.");
        addSubheaderWithText("Education Research");
        addTextViewWithText("Health4TheWorld is committed to advancing the science of learning and teaching, and records of your participation in courses may be used for education research. In the interest of this research, you may be exposed to variations in the course content. Research findings will typically be reported at the aggregate level. Your personal identity will not be publicly disclosed in any research findings without your express consent.");
        addSubheaderWithText("Disclaimer about Medical Content and its Use");
        addTextViewWithText("The information provided and views and opinions expressed by any individuals during the course of lecturers, mobile application content or via any other services,  are their own and do not necessarily represent the views, opinions, or positions of the Health4TheWorld or any of its subsidiary programs or divisions. The channel, site, and all materials contained herein or otherwise affiliated with Health4TheWorld are intended only for educational purposes, and are not intended to be, and should not be interpreted as, medical advice. Although reasonable efforts have been made to ensure the information contained in these lectures and educational material in the mobile application was current and accurate at the time of publication, neither Health4TheWorld, nor any individual who has furnished content or been involved in the presentation of this material, either orally or in writing can guarantee that all information is accurate and valid. Health4TheWorld makes no warranty, express or implied, that any information provided in the lectures is accurate or has remained accurate due to advances in research, or changes to guidelines and other standards of care. Nothing contained in any lecture, podcast, mobile application or other media platform creates or has created or is intended to create, implicitly or explicitly, any manner of patient-physician relationship.");

        addHeaderWithText("Your Content");
        addLineBreak();
        addSubheaderWithText("User Content");
        addTextViewWithText("The Website, Mobile application and Services enable you to share your content, such as quizzes, exams, projects, assignments, and other content you submit in association with your use of the Website and Services, including without limitation any data, text, links, video files, photos, posts you make in the forums, and the like (\"User Content\"), with Health4TheWorld, instructors, and/or other users. Such User Content will be deemed to be non-confidential and shall also include any content you submit to Health4TheWorld via our “Contact Us” page or by emailing any employees of Health4TheWorld. You represent and warrant that all User Content that you may send to Health4TheWorld shall be your wholly original material (except for material that you are using with the permission of its owner), and does not misappropriate, infringe or otherwise violate any copyright, trademark, intellectual property or other rights of any third party, including any rights of privacy or publicity.");
        addSubheaderWithText("How Health4TheWorld and Others May Use User Content");
        addTextViewWithText("To the extent that you provide User Content, you grant Health4TheWorld a fully-transferable, royalty-free, perpetual, sublicensable, non-exclusive, worldwide license to copy, distribute, modify, create derivative works based on, publicly perform, publicly display, and otherwise use the User Content. This license includes granting Health4TheWorld the right to authorize participating institutions to use User Content with their registered participants independent of the Website and Services. Nothing in these Terms shall restrict other legal rights Health4TheWorld may have to User Content, for example under other licenses, or our rights to use any User Content in any way we choose. We further reserve the right to remove or modify User Content for any reason, including User Content that we believe violates these Terms.");
        addSubheaderWithText("Feedback");
        addTextViewWithText("We welcome your suggestions, ideas, comments, and other feedback regarding the Website or Services (\"Feedback\"). By submitting any Feedback, you grant us the right to use the Feedback without any restriction or any compensation to you. By accepting your Feedback, Health4TheWorld does not waive any rights to use similar or related Feedback previously known to Health4TheWorld, developed by its employees or contractors, or obtained from other sources.");

        addHeaderWithText("Security");
        addLineBreak();
        addTextViewWithText("We care about the security of our users. While we work to protect the security of your account and related information, Health4TheWorld cannot guarantee that unauthorized third parties will not be able to defeat our security measures. Please notify us immediately of any compromise or unauthorized use of your account by emailing contact@Health4TheWorld.org.");

        addHeaderWithText("Third Party Content");
        addLineBreak();
        addTextViewWithText("Through the Website and/or Services, you will have the ability to access and/or use content provided by instructors, other users, and/or other third parties and links to websites, software and services maintained and/or controlled by third parties. Health4TheWorld has no control over, and assumes no responsibility for, the content, privacy policies, or practices of any third party websites or content providers and cannot guarantee that such third party content, in the Website, Services or elsewhere, will be free of material you may find objectionable or otherwise inappropriate or of malware or other contaminants that may harm your computer, mobile device, or any files therein. By using the Website, Mobile application or the Services, you expressly relieve the Health4TheWorld from and we expressly disclaim any responsibility or liability related to or arising from your access or use of such third party content or website. Any use of such third-party software or services is at your own risk and may subject you to additional or different terms and restrictions by the third party or third parties providing such software or operating such services.  Accordingly, we encourage you to be aware of and to read the terms and conditions and privacy policy for each item of third party software or each third party service through which you access the Website or Services.");

        addHeaderWithText("Copyright and Trademark Policy");
        addLineBreak();
        addTextViewWithText("Health4TheWorld respects the intellectual property rights of our users, participating institutions, and other third parties and expects our users to do the same when using the Website or Services. We have adopted and implemented the Health4TheWorld Copyright and Trademark Policy in accordance with applicable law, including the Digital Millennium Copyright Act.");

        addHeaderWithText("Modifying and Terminating our Services");
        addLineBreak();
        addTextViewWithText("We are constantly changing and improving our Website, Mobile Applications and Services. We may add or remove functions, features, or requirements, and we may suspend or stop a function of our Website or Services altogether. Accordingly, Health4TheWorld may terminate your use of the Website and any Services for any reason. If your use of a paid feature or the Website, Mobile application or Services is terminated, a refund may be available under our Refund Policy. None of Health4TheWorld, its participating institutions and instructors, its contributors, sponsors, and other business partners, and their respective employees, officers, directors, representatives, contractors, and other agents (collectively the \"Health4TheWorld Parties\") shall have any liability to you for any such action. You can stop using our Website or Services at any time.");

        addHeaderWithText("Disclaimers");
        addLineBreak();
        addTextViewWithText("THE WEBSITE, MOBILE APPLICATION AND ANY INFORMATION, CONTENT OR SERVICES MADE AVAILABLE ON OR THROUGH THE WEBSITE & MOBILE APPLICATION ARE PROVIDED \"AS IS\" AND \"AS AVAILABLE\" WITHOUT WARRANTY OF ANY KIND (EXPRESS, IMPLIED OR OTHERWISE), INCLUDING, WITHOUT LIMITATION, ANY IMPLIED WARRANTIES OF TITLE, MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NON-INFRINGEMENT, EXCEPT INSOFAR AS ANY SUCH IMPLIED WARRANTIES MAY NOT BE DISCLAIMED UNDER APPLICABLE LAW.");
        addTextViewWithText("THE HEALTH4THEWORLD PARTIES DO NOT WARRANT THAT THE WEBSITE, MOBILE APPLICATION OR SERVICES WILL OPERATE IN AN UNINTERRUPTED OR ERROR-FREE MANNER, THAT THE WEBSITE OR SERVICES ARE FREE OF ERRORS, VIRUSES OR OTHER HARMFUL COMPONENTS, OR THAT THE COURSES OR CONTENT PROVIDED WILL MEET YOUR NEEDS OR EXPECTATIONS. THE HEALTH4THEWORLD PARTIES ALSO MAKE NO WARRANTY ABOUT THE ACCURACY, COMPLETENESS, TIMELINESS, OR QUALITY OF THE WEBSITE, MOBILE APPLICATION OR SERVICES OR ANY COURSES OR CONTENT, OR THAT ANY PARTICULAR COURSES OR CONTENT WILL CONTINUE TO BE MADE AVAILABLE. USE OF THE WEBSITE, MOBILE APPLICATION AND THE CONTENT AND SERVICES OBTAINED FROM OR THROUGH THE WEBSITE & MOBILE APPLICATION, IS AT YOUR OWN RISK. YOUR ACCESS TO OR DOWNLOAD OF INFORMATION, MATERIALS, SOFTWARE OR DATA THROUGH THE WEBSITE, MOBILE APPLICATIONS OR ANY REFERENCE SITES IS AT YOUR OWN DISCRETION AND RISK, AND YOU WILL BE SOLELY RESPONSIBLE FOR ANY DAMAGE TO YOUR PROPERTY (INCLUDING YOUR COMPUTER SYSTEM) OR LOSS OF DATA THAT RESULTS FROM THE DOWNLOAD OR USE OF SUCH MATERIALS, SOFTWARE OR DATA, UNLESS OTHERWISE EXPRESSLY PROVIDED FOR IN THE HEALTH4THEWORLD PRIVACY POLICY. FOR THE AVOIDANCE OF DOUBT, IN NO EVENT SHALL THE HEALTH4THEWORLD PARTIES BE LIABLE TO YOU FOR ANY DEFICIENCY, ERROR, INACCURACY OR INTERRUPTION IN THE WEBSITE, MOBILE APPLICATION OR SERVICES OR FOR DAMAGES OF ANY KIND. YOUR SOLE REMEDY IN THE EVENT OF ANY DEFICIENCY, ERROR, OR INACCURACY SHALL BE TO REQUEST THAT HEALTH4THEWORLD CORRECT THE MATTER OR, IF WE FAIL TO DO SO, TO DISCONTINUE YOUR USE OF THE WEBSITE AND/OR SERVICES.");

        addHeaderWithText("Limitation of Liability");
        addLineBreak();
        addTextViewWithText("TO THE MAXIMUM EXTENT PERMITTED BY LAW, THE HEALTH4THEWORLD PARTIES SHALL NOT BE LIABLE FOR ANY INDIRECT, INCIDENTAL, SPECIAL, CONSEQUENTIAL, OR PUNITIVE DAMAGES, OR ANY LOSS OF PROFITS OR REVENUES, WHETHER INCURRED DIRECTLY OR INDIRECTLY, OR ANY LOSS OF DATA, USE, GOODWILL, OR OTHER INTANGIBLE LOSSES, RESULTING FROM: (A) YOUR ACCESS TO OR USE OF OR INABILITY TO ACCESS OR USE THE WEBSITE, MOBILE APPLICATION OR SERVICES; (B) ANY CONDUCT OF ANY PARTY OTHER THAN THE APPLICABLE HEALTH4THEWORLD PARTIES, INCLUDING WITHOUT LIMITATION, ANY DEFAMATORY, OFFENSIVE, OR ILLEGAL CONDUCT ; (C) ANY CONTENT OBTAINED FROM THE WEBSITE, MOBILE APPLICATION OR SERVICES,; OR (C) UNAUTHORIZED ACCESS, USE, OR ALTERATION OF YOUR USER CONTENT OR ANY INFORMATION PROVIDED BY YOU. IN NO EVENT SHALL THE HEALTH4THEWORLD PARTIES’ AGGREGATE LIABILITY FOR ALL CLAIMS RELATED TO THE WEBSITE AND/OR SERVICES EXCEED THE GREATER OF TWENTY U.S. DOLLARS ($20) OR THE TOTAL AMOUNT OF FEES RECEIVED BY HEALTH4THEWORLD FROM YOU FOR THE USE OF PAID FUNCTIONS OF THE WEBSITE, MOBILE APPLICATION AND SERVICES DURING THE PAST SIX (6) MONTHS.");
        addTextViewWithText("YOU ACKNOWLEDGE AND AGREE THAT THE DISCLAIMERS AND THE LIMITATIONS OF LIABILITY SET FORTH IN THE TERMS REFLECT A REASONABLE AND FAIR ALLOCATION OF RISK BETWEEN YOU AND THE HEALTH4THEWORLD PARTIES, AND THAT THESE LIMITATIONS ARE AN ESSENTIAL BASIS TO HEALTH4THEWORLD'S ABILITY TO MAKE THE WEBSITE AND SERVICES AVAILABLE TO YOU ON AN ECONOMICALLY FEASIBLE BASIS.");
        addTextViewWithText("YOU AGREE THAT ANY CAUSE OF ACTION RELATED TO THE WEBSITE, MOBILE APPLICATION OR SERVICES MUST COMMENCE WITHIN ONE (1) YEAR AFTER THE CAUSE OF ACTION ACCRUES, OTHERWISE, SUCH CAUSE OF ACTION IS PERMANENTLY BARRED.");

        addHeaderWithText("Indemnification");
        addLineBreak();
        addTextViewWithText("You agree to indemnify, defend, and hold harmless the Health4TheWorld Parties from any and all claims, liabilities, expenses, and damages, including reasonable attorneys' fees and costs, made by any third party arising from or related to: (a) your use or attempted use of the Website and/or Services in violation of these Terms; (b) your violation of any law or rights of any third party;  (c) the User Content; or (d) or any claim of infringement or misappropriation of intellectual property or other proprietary rights of any person or entity by you.");

        addHeaderWithText("Governing Law and Jurisdiction");
        addLineBreak();
        addTextViewWithText("The Services are managed by Health4TheWorld, which is located in Palo Alto, California, USA. You agree that any dispute arising under or related to these Terms will be governed by the laws of the United States of America and the State of California, excluding its conflicts of law provisions. You further consent to the personal jurisdiction of and exclusive venue in the federal and state courts located in and serving Palo Alto, California as the legal forum for any such dispute, and waive any objection as to inconvenient forum.");
        addTextViewWithText("Excluding claims for injunctive or other equitable relief, for claims related to the Services where the total amount sought is less than ten thousand U.S. Dollars ($10,000.00 USD), either you or Health4TheWorld may elect at any point during the dispute to resolve the claim through binding, non-appearance-based arbitration. The dispute will then be resolved using an established alternative dispute resolution (\"ADR\") provider, mutually agreed upon by you and Health4TheWorld. The parties and the selected ADR provider shall not involve any personal appearance by the parties or witnesses, unless otherwise mutually agreed by the parties; rather, the arbitration shall be conducted, at the option of the party seeking relief, online, by telephone, or via written submissions alone. Any judgment rendered by the arbitrator may be entered in any court of competent jurisdiction. ");

        addHeaderWithText("General Terms");
        addLineBreak();
        addSubheaderWithText("Revisions to the Terms");
        addTextViewWithText("We reserve the right to revise the Terms at our sole discretion at any time. Any revisions to the Terms will be effective immediately upon posting by us. For any material changes to the Terms, we will attempt to notify you of such changes; however, we do not assume any obligation to notify you of changes to these Terms. In all cases, your continued use of the Website and/or Services after publication of such changes, with or without notification, constitutes binding acceptance of the revised Terms.");
        addSubheaderWithText("Successors");
        addTextViewWithText("These Terms shall be binding on and inure to the benefit of your respective successors and assigns.");
        addSubheaderWithText("Severability; Waiver");
        addTextViewWithText("If it turns out that a particular provision of these Terms is not enforceable, this will not affect any other provisions of these Terms. If you do not comply with these Terms, and we do not take immediate action, this does not indicate that we relinquish any rights that we may have (such as taking action in the future).");
        addSubheaderWithText("Participating Institutions");
        addTextViewWithText("Health4TheWorld's participating institutions are third party beneficiaries of the Terms and may enforce those provisions of the Terms that relate to them.");
        addSubheaderWithText("Notice for California Users");
        addTextViewWithText("Under California Civil Code Section 1789.3, California website users are entitled to the following specific consumer rights notice: The Complaint Assistance Unit of the Division of Consumer Services of the California Department of Consumer Affairs may be contacted in writing at 1625 N. Market Blvd., Suite S-202, Sacramento, California 95834, or by telephone at (800) 952-5210.");

        addHeaderWithText("Referenced Policies");
        addLineBreak();
        addIndentedTextViewWithText("• Acceptable Use Policy");
        addIndentedTextViewWithText("• Privacy Policy");
        addIndentedTextViewWithText("• Copyright and Trademark Infringement Policy");
        addIndentedTextViewWithText("• Honor Code");

        addHeaderWithText("Acceptable Use Policy");
        addLineBreak();
        addTextViewWithText("Health4TheWorld's mission is to provide universal access to health educational materials to improve global health through the use of our website (www.Health4TheWorld.org), which includes, media, documentation, pictures and other content (collectively, the \"Website\"), as well as for access to and use of any products, services, and downloadable applications provided by Health4TheWorld (the “Services”). We believe strongly in preserving free speech and expression for our learners as well as academic freedom for our partner institutions and instructors. We also want to make sure that all of our learners and instructors feel safe and comfortable while using our Website and Services. We have drafted these guidelines to ensure that people understand and follow the rules when participating in our online community and otherwise using our Website and Services.");
        addTextViewWithText("Although we do not routinely screen or monitor content provided by users, we may remove or edit inappropriate content or activity reported to us or suspend, disable, or terminate a user's access to all or part of our Website or Services. Please keep in mind users who are as young as 13 years of age use our Website and Services, and we do not allow content that is inappropriate for these younger learners.");
        addSubheaderWithText("You are prohibited from using our Website or Services to share content that:");
        addIndentedTextViewWithText("• Contains illegal content or promotes illegal activities with the intent to commit such activities.");
        addIndentedTextViewWithText("• Contains credible threats or organizes acts of real-world violence. We do not allow content that creates a genuine risk of physical injury or property damage, credibly threatens people or public safety, or organizes or encourages harm.");
        addIndentedTextViewWithText("• Harasses others. We encourage commentary about people and matters of public interest, but abusive or otherwise inappropriate content directed at private individuals is not allowed.");
        addIndentedTextViewWithText("• Violates the intellectual property, privacy, or other rights of third parties. Do not share content that you do not have the right to share, claim content that you did not create as your own, or otherwise infringe or misappropriate someone else’s intellectual property or other rights. Always attribute materials used or quoted by you to the original owner.");
        addIndentedTextViewWithText("• Spams others. Do not share irrelevant or inappropriate advertising, promotional, or solicitation content.");
        addIndentedTextViewWithText("• Otherwise violates the Health4TheWorld Terms of Use. Please note that specific courses may have additional rules and requirements.");
        addSubheaderWithText("You also are not allowed to:");
        addIndentedTextViewWithText("• Do anything that violates local, state, national or international law or breaches any of your contractual obligations or fiduciary duties.");
        addIndentedTextViewWithText("• Share your password, let anyone access your account, or do anything that might put your account at risk.");
        addIndentedTextViewWithText("• Attempt to access any other user's account.");
        addIndentedTextViewWithText("• Reproduce, transfer, sell, resell, or otherwise misuse any content from our Website or Services, unless specifically authorized to do so.");
        addIndentedTextViewWithText("• Access, tamper with, or use non-public areas of our systems, unless specifically authorized to do so.");
        addIndentedTextViewWithText("• Break or circumvent our authentication or security measures or otherwise test the vulnerability of our systems or networks, unless specifically authorized to do so.");
        addIndentedTextViewWithText("• Try to reverse engineer, reverse engineer, decompile, decode, decrypt, disassemble, or in any way derive source code from any portion of our Website or Services.");
        addIndentedTextViewWithText("• Try to interfere with any user, host, or network, for example by sending a virus, overloading, spamming, or mail-bombing.");
        addIndentedTextViewWithText("• Use our Website or Services to distribute malware, viruses, Trojan horses, worms, spyware, corrupted files or any other similar software that may damage the operation of another's computer or property.");
        addIndentedTextViewWithText("• Impersonate or misrepresent your affiliation with any person or entity.");
        addIndentedTextViewWithText("• Encourage or help anyone do any of the things on this list.");
        addSubheaderWithText("The following list of items is strictly prohibited on the Website: ");
        addIndentedTextViewWithText("• Content that defames, harasses or threatens others;");
        addIndentedTextViewWithText("• Content that discusses illegal activities with the intent to commit them;");
        addIndentedTextViewWithText("• Content that infringes another's intellectual property, including, but not limited to, copyrights or trademarks;");
        addIndentedTextViewWithText("• Profane, pornographic, obscene, indecent or unlawful content;");
        addIndentedTextViewWithText("• Advertising or any form of commercial solicitation;");
        addIndentedTextViewWithText("• Content related to partisan political activities;");
        addIndentedTextViewWithText("• Viruses, Trojan horses, worms, time bombs, corrupted files, malware, spyware or any other similar software that may damage the operation of another's computer or property; and");
        addIndentedTextViewWithText("• Content that contains intentionally inaccurate information or that is posted with the intent of misleading others.");
        addTextViewWithText("Furthermore, you agree not to scrape, or otherwise download in bulk, any Website content, including but not limited to a list or directory of users on the system, on-line textbooks, User Content or user information. You agree not to misrepresent or attempt to misrepresent your identity while using the Website (although you are welcome and encouraged to use an anonymous username in the forums and to act in a manner that keeps your identity concealed).");
        addSubheaderWithText("User Content");
        addSubheaderWithText("User Content Representations and Warranties ");
        addTextViewWithText("By submitting or distributing your User Content through the Website and/or Services, you affirm, represent and warrant (1) that you have the necessary rights, licenses, consents and/or permissions to reproduce and publish the User Content and to authorize Health4TheWorld and its users to reproduce, modify, publish and otherwise use and distribute your User Content in a manner consistent with the licenses granted by you below, and (2) that neither your submission of your User Content nor the exercise of the licenses granted below will infringe or violate the rights of any third party. You, are solely responsible for your User Content and the consequences of its posting or publishing. “User Content” is defined herein as any and all content shared or submitted by you in association with your use of the Website and/or Services, including without limitation any data, text, links, video files, photos, documents, materials, or posts you make in the forums, and the like (\"User Content\")");
        addSubheaderWithText("License Grant to Health4TheWorld");
        addTextViewWithText("By submitting or distributing your User Content, you hereby grant to Health4TheWorld a worldwide, non-exclusive, transferable, assignable, sub-licensable, fully paid-up, royalty-free, perpetual, irrevocable right and license to host, transfer, display, perform, reproduce, modify, distribute, re-distribute, relicense and otherwise use, make available and exploit your User Content, in whole or in part, in any form and in any media formats and through any media channels (now known or hereafter developed).");
        addSubheaderWithText("License Grant to Health4TheWorld Users");
        addTextViewWithText("By submitting or distributing your User Content, you hereby grant to each user of the Website or Services a non-exclusive license to access and use your User Content in connection with their use of the Website and/or Services for their own personal purposes.");

        addHeaderWithText("Copyright and Trademark Policy");
        addLineBreak();
        addTextViewWithText("Health4TheWorld respects the intellectual property rights of our instructors and other third parties and expects our users to do the same when using the Health4TheWorld.org website, and any associated media, documentation, pictures or other content (collectively the ”Website), or any related services, products or applications (the “Services”). We reserve the right to suspend, disable, or terminate the accounts of users who infringe or who are charged with infringing the copyrights, trademarks, or other intellectual property rights of third parties.");
        addSubheaderWithText("Copyrights");
        addTextViewWithText("The Digital Millennium Copyright Act of 1998 (the \"DMCA\") provides recourse for copyright owners who believe that material appearing on the Internet infringes their rights under U.S. copyright law. A copy of the DMCA is available on the website of the U.S. Copyright Office, located at http://www.copyright.gov/legislation/dmca.pdf");
        addTextViewWithText("If you believe in good faith that any materials contained on the Website or provided through the Service infringe your copyright(s), the DMCA provides that you (or your agent) may send us a notice requesting that the infringing material be removed or access to it blocked.");
        addTextViewWithText("Notices under the DMCA must include the following information:");
        addIndentedTextViewWithText("1. the physical or electronic signature of a person authorized to act on behalf of the owner of an exclusive right that is allegedly infringed;");
        addIndentedTextViewWithText("2. identification of the copyrighted work claimed to have been infringed (or, if multiple copyrighted works located on the Website or provided through the Services are covered by a single notification, a representative list of such works);");
        addIndentedTextViewWithText("3. identification of the material that is claimed to be infringing or the subject of infringing activity, and information reasonably sufficient to allow Health4TheWorld to locate the material on the Website or in the Services;");
        addIndentedTextViewWithText("4. the name, address, telephone number, and email address (if available) of the complaining party;");
        addIndentedTextViewWithText("5. a statement that the complaining party has a good faith belief that use of the material in the alleged manner is not authorized by the copyright owner, its agent, or under law; and");
        addIndentedTextViewWithText("6. a statement, under penalty of perjury, that the information in the notification is accurate and the complaining party is authorized to act on behalf of the owner of the copyright that is allegedly infringed.");
        addTextViewWithText("Notices must meet the then-current statutory requirements imposed by the DMCA. Notices and counter-notices with respect to the Website and/or Services can either be sent:");
        addIndentedTextViewWithText("1. via mail to: Copyright Agent, Health4TheWorld, 501 Forest Ave Apt 1207, Palo Alto CA 94301");
        addIndentedTextViewWithText("2. via email to: contact@health4theworld.org");
        addTextViewWithText("We suggest that you consult your legal advisor before filing a DMCA notice, as false claims under the DMCA may subject filers to statutory penalties.");
        addSubheaderWithText("Trademarks");
        addTextViewWithText("Health4TheWorld also respects the trademark rights of others. Accounts containing content that intentionally misleads others or violates a third-party’s trademark rights may be modified, suspended, disabled, or terminated by Health4TheWorld in its sole discretion, without notice. If you are concerned that someone may be using your trademark in an infringing or unauthorized manner on our Website or Services, please email us at contact@Health4TheWorld.org, and we will review your complaint. If we deem appropriate, we may remove the offending content, warn the user who posted the content, and/or temporarily or permanently suspend or disable the individual’s account.");

        addHeaderWithText("Honor Code");
        addLineBreak();
        addTextViewWithText("All users participating in any class must agree to abide by the following code of conduct. I hereby agree: ");
        addIndentedTextViewWithText("1. I will register for only one (1) user account on Health4TheWorld.com.");
        addIndentedTextViewWithText("2. My answers to quizzes, exams, projects, and other assignments will be my own work (except for assignments that explicitly permit collaboration).");
        addIndentedTextViewWithText("3. I will not make solutions to quizzes, exams, projects, and other assignments available to anyone else (except to the extent an assignment explicitly permits sharing solutions). This includes both solutions written by me, as well as any solutions provided by the course staff or others.");
        addIndentedTextViewWithText("4. I will not engage in any other activities that will dishonestly improve my results or dishonestly improve or hurt the results of others.");

    }

    public void setUpPrivacyPolicy() {
        addHeaderWithText("Purpose");
        addLineBreak();
        addTextViewWithText("The purpose of this privacy policy (this “Privacy Policy”) is to describe how Health4TheWorld (“Health4TheWorld”, “we,” “us,” or “our”) collects, uses and shares information and data about you through our online interfaces (e.g., websites, services, products and applications, including mobile applications), including Health4TheWorld.org (collectively referred to herein as the \"Website\"). Please read this notice carefully to understand how we use and disclose information collected through our Website. If you do not understand any aspects of our Privacy Policy, please feel free to contact us at www.Health4TheWorld.org.");
        addSubheaderWithText("IMPORTANT NOTE:");
        addTextViewWithText("By accessing, using, or viewing the Website, you expressly consent to our collection, use, and disclosure of your personal information in accordance with the terms and conditions of this Privacy Policy.  This Privacy Policy is incorporated into and subject to the Terms of Use for the Website (“Terms”). When reading through this Privacy Policy please read the entire contents and do not rely on headings, which are illustrative of some but not all of the contents and should not be read so as to limit any of the terms and conditions detailed below each heading.");

        addHeaderWithText("What Information this Privacy Policy Covers");
        addLineBreak();
        addTextViewWithText("This Privacy Policy covers information we collect from you through use of our Website, and any personal information that you provide to us, including through email.  We shall explain in this Privacy Policy what information we collect about you through your use of the Website or when you contact us electronically and how we use that information.  Some of our Website’s functionality can be used without revealing any “Personal Information” (i.e., information that can be used to identify you); however, for features or services related to our online courses, such Personal Information is required.  If you do not use these specific features or services on the Website, then the only information we collect will be \"De-identified Information\" (i.e., information that cannot be used to identify you). De-identified Information includes information such as the web pages that you have viewed. In order to access certain features and benefits on our Website, you may need to submit Personal Information.");
        addTextViewWithText("You are responsible for ensuring the accuracy of all Personal Information you submit to Health4TheWorld. Inaccurate information may affect your ability to use the Website, the information you receive when using the Website, and our ability to contact you.");

        addHeaderWithText("What You Consent to by Using Our Website");
        addLineBreak();
        addTextViewWithText("Please understand that by submitting any Personal Information to us, you consent and agree that we may collect, use and disclose such Personal Information in accordance with this Privacy Policy and our Terms, and as permitted or required by law. Participation in Forums and online classrooms on the Website requires the public release and dissemination of your information, and thus we cannot commit to treating such information confidentially in the same manner that other Personal Information will be treated under this Privacy Policy.  Participation in these features of the Website is voluntary and thus your consent to certain terms is required before participation is allowed.  If you do not agree with these terms, then please do not provide any Personal Information to us.  If you refuse or withdraw your consent, or if you choose not to provide us with any required Personal Information, we may not be able to provide you with the services that can be offered on our Website.");

        addHeaderWithText("What Information We Collect");
        addLineBreak();
        addTextViewWithText("We collect three types of information about users:  (1) \"Personal Information\" such as name, email address, IP address, geotag device data, social media account user name or ID , phone number and personal preferences, and other account-related information; (2) “De-identified Information” in which all personal and individually identifiable identifiers have been removed such as statistical information on health care services used in a particular geo-location and what web pages you visit;  and (3) \"Aggregate Information\" which is anonymous information about you that is used in a collective manner and which no single person or user can be identified by such compiled information, such as information about how many users log on to the Website on a daily basis.");
        addSubheaderWithText("De-identified Information.");
        addTextViewWithText("When users come to our Website, we may track, collect and use De-identified Information in which all personal and individually identifiable identifiers have been removed.  Among other things, we may use De-identified Information to determine which pages of our Website were visited, the order in which they were visited, when they were visited, and which hyperlinks were \"clicked.\" We also collect information from the URLs from which you linked to our Website. Collecting such information may involve logging the IP address, operating system and browser software used by each user of the Website. Although such information is not Personal Information, we may be able to determine from an IP address a user’s Internet Service Provider and the geographic location of his or her point of connectivity.");
        addSubheaderWithText("Aggregate Information.");
        addTextViewWithText("We also aggregate De-identified Information about users so that no single person or user can be identified.  We use such Aggregate Information to determine information such as what Website pages are most frequently accessed and the number of people logged into the Website on a particular day.");
        addSubheaderWithText("Personal Information.");
        addTextViewWithText("We collect Personal Information that you provide to us when you register for an account, purchase products or services, complete a survey, sign-up for email updates or online courses, blog, donate, send us communications, and/or participate in online courses or other services on our Website. We may use the Personal Information that you provide to respond to your questions, provide you the specific course and/or services you select, send you updates about online courses offered by Health4TheWorld or other Health4TheWorld events, promotions by Health4TheWorld or our partners, and send you email messages about Website maintenance or updates.  We may also receive Personal Information when you access or log-in to a third party site, e.g., Facebook, from our Websites. This may include the text and/or images of your Personal Information available from a third party site.  By providing information using the Website, you further warrant to Health4TheWorld that your Personal Information is reliable for its intended uses, accurate, complete and correct, and that you will promptly notify us if such Personal Information is no longer current or correct.  Personal Information shall NOT include any information posted or sent by or to you in any Forum (such as a comment box on a particular blog or in our online classrooms or through social media accounts) on the Websites.");
        addSubheaderWithText("Partners.");
        addTextViewWithText("Partner sites providing online course related tools and services to Health4TheWorld users may collect nonfinancial individual level user data regarding the individual’s use of that partner site while engaged with such online course related activities, and the partner sites may share that data with Health4TheWorld for the purpose of improving Health4TheWorld’s services, the partner site’s services, and the individual’s education experience. This data includes but is not limited to information such as the amount of time spent on the partner site and pages viewed.");
        addSubheaderWithText("Third Party Credit Card Processing.");
        addTextViewWithText("Health4TheWorld provides you with the ability to donate using a credit card through third party payment processing service providers. Please note that our service providers – not Health4TheWorld– collect and process your credit card information.  We make no representations or warranties about the acts or omissions of such third party payment processing service providers, including whether such parties will keep your information confidential.  Health4TheWorld shall not be liable for any misuse of such information by any third party payment processing service or otherwise.");
        addSubheaderWithText("Use of Cookies.");
        addTextViewWithText("When you visit the Website, we may place one or more “cookies” on your computer.  Essentially, cookies are a user’s identification card for the Health4TheWorld servers.  They allow websites to store information such as user preferences, but do not collect Personal Information, only De-identified Information.  Cookies and web beacons allow Health4TheWorld to serve you better and more efficiently, and to personalize your experience at our Website.  From time to time we may also use cookies and/or web beacons to help us determine and identify repeat visitors, the type of content and sites to which a user of our Website links, the length of time each user spends at any particular area of our Website, to track the specific functionalities and content that users choose to use, to improve the Website’s content and conduct various other diagnostics to improve our services, and to analyze and improve Website security. Web beacons are small graphic files linked to our servers that allow us to track your use of our Website and related functionalities.");
        addTextViewWithText("You should be able to control how and whether cookies will be accepted by your web browser. Most browsers offer instructions on how to reset the browser to reject cookies in the \"Help\" section of the toolbar.  If you reject our cookies, many functions and conveniences of this Website may not work properly.");

        addHeaderWithText("How We Use the Information");
        addLineBreak();
        addTextViewWithText("The information Health4TheWorld collects is used to for multiple purposes as described below. ");
        addSubheaderWithText("De-identified Information.");
        addTextViewWithText("We use De-identified Information to build higher quality, more useful services by performing statistical analyses of the collective characteristics and behavior of our users, and by measuring demographics and interests regarding specific areas of our Website. We may also use it for other business purposes.");
        addSubheaderWithText("Aggregate Information.");
        addTextViewWithText("We use aggregate, anonymous, non-personally identifiable information about you in a collective manner, so that no single person or user can be identified. We use such Aggregate information to determine information such as what Website pages are most frequently accessed and the number of people logged into the Website on a particular day.  We may also use it for other business purposes.");
        addSubheaderWithText("Personal Information.");
        addTextViewWithText("Except as set forth in this Privacy Policy or as specifically agreed to by you, Health4TheWorld will not disclose any Personal Information we gather from you on the Website. In addition to the other uses set forth in this Privacy Policy, we may disclose and otherwise use Personal Information as described below. We may also use it for research and business purposes, including improving and customizing the Website and the products and services we offer. The Personal Information (including your email address) we collect is not sold to other organizations for commercial or marketing purposes.");
        addSubheaderWithText("Updates.");
        addTextViewWithText("We use Personal Information collected when you sign-up for our various email or update services to send you the messages in connection with the Website or an online course. We may also archive this information and/or use it for future communications with you.");
        addSubheaderWithText("Forums.");
        addTextViewWithText("Health4TheWorld may offer public forums from time to time (the \"Forums\") where you can share comments and thoughts. In order to participate in the Forums, you may be required to register with us and/or provide us with Personal Information such as your name and email address.  To facilitate your use of the Forums, we may also use De-identified Information and other non-Personal Information  collected during your use of the Forums for business purposes, and may publish this information via extensions of our platform that use third party services, like mobile applications and via social media applications. We also reserve the right to reuse Forum posts to enhance future course offerings. We may archive this information and/or use it for future communications with you and/or your designee(s), and/or provide it to the university or the instructor(s) associated with the courses you have taken. We may also use or publish posts submitted on the Forums without using Personal Information. Please keep in mind that information you post or make available in Forums will be publicly available. Accordingly, you should be careful when posting any personal or sensitive information.");
        addSubheaderWithText("Participation in online courses.");
        addTextViewWithText("We use the Personal Information that we collect from you when you participate in an online course through the Website for processing purposes, including but not limited to tracking attendance, progress and completion of an online course. We may also share your Personal Information and your performance in a given online course with the instructor or instructors who taught the course, with teaching assistants or other individuals designated by the instructor or instructors to assist with the creation, modification or operation of the course, and with the institution or institutions with which they are affiliated. Also, we may archive this information and/or use it for future communications with you.");
        addSubheaderWithText("Communications with Us.");
        addTextViewWithText("When you send us an email message or otherwise contact us, we may use the information provided by you to respond to your communication and/or as described in this Privacy Policy. We may also archive this information and/or use it for future communications with you.");
        addSubheaderWithText("Communications with Our Partners.");
        addTextViewWithText("We may share your Personal Information with university partners and other business partners of Health4TheWorld so that university partners and other business partners may share information about their products and services that may be of interest to you.");
        addSubheaderWithText("Research.");
        addTextViewWithText("We may share general course data (including quiz or assignment submissions, grades, and Forum discussions), information about your activity on our Website, and demographic data from surveys operated by us with our university partners and other business partners so that our university partners and other business partners may use the data for research related to online education.");
        addSubheaderWithText("Disclosure to Third Party Contractors.");
        addTextViewWithText("We use various third party service providers, vendors and contractors (collectively, \"Contractors\") to assist us in providing our products and services to you. Our Contractors may have limited access to your Personal Information in the course of providing their products or services to us, so that we in turn can provide our products and services to you. These Contractors may include vendors and suppliers that provide us with technology, services, and/or content related to the operation and maintenance of the Website or the online courses. Access to your Personal Information by these Contractors is limited to the information reasonably necessary for the Contractor to perform its limited function for us. We make no representations or warranties about the acts or omissions of such Contractors, including whether such parties will keep such information confidential.  When you contact Health4TheWorld and provide information to us pursuant to your use of the Website, you do so at your own risk, and Health4TheWorld shall not be liable for any misuse of such information by any third party or Contractor.");
        addSubheaderWithText("Government Authorities, Legal Rights and Actions.");
        addTextViewWithText("Health4TheWorld may share your Personal Information with various government authorities in response to subpoenas, court orders, or other legal process; to establish or exercise our legal rights or to protect our property; to defend against legal claims; or as otherwise required by law. In such cases we reserve the right to raise or waive any legal objection or right available to us. We also may share your Personal Information when we believe it is appropriate to investigate, prevent, or take action regarding illegal or suspected illegal activities; to protect and defend the rights, property, or safety of Health4TheWorld, the Website, our users, customers, or others; and in connection with verifying or enforcing compliance with our Terms and other agreements.");
        addSubheaderWithText("Disclosure to Acquirers.");
        addTextViewWithText("Health4TheWorld may disclose and/or transfer your Personal Information to an acquirer, assignee or other successor entity in connection with a sale, merger, or reorganization of all or substantially all of the equity, business or assets of Health4TheWorld to which your Personal Information relates.");
        addSubheaderWithText("e-Readers.");
        addTextViewWithText("If we receive any Personal Information related to the extent to which you use designated e-Readers to access Health4TheWorld materials, we may archive it, and use it for research, business, or other purposes.");

        addHeaderWithText("External Links");
        addLineBreak();
        addTextViewWithText("For your convenience we may provide links to sites operated by organizations other than Health4TheWorld (\"Third Party Websites\") that we believe may be of interest to you. We do not disclose your Personal Information to these Third Party Websites without obtaining your consent. We do not endorse and are not responsible for the privacy practices of these Third Party Websites. The policies and procedures we describe here do not apply to Third Party websites, and Health4TheWorld expressly disclaims any and all liability related to the use of any Third Party Websites.  If you choose to click on a link to one of these Third Party Websites, you should review the privacy policy posted on the other site to understand how that Third Party Website collects and uses your Personal Information.");

        addHeaderWithText("Confidentiality & Security of Personal Information");
        addLineBreak();
        addTextViewWithText("We consider the confidentiality and security of your information to be of the utmost importance. We will use industry standard physical, technical and administrative security measures to keep your Personal Information confidential and secure and will not share it with third parties, except as otherwise provided in this Privacy Policy, or unless we have good faith belief that such disclosure is necessary in special cases, such as a physical threat to you or others. Because the Internet is not a 100% secure environment we cannot guarantee the security of Personal Information, and there is some risk that an unauthorized third party may find a way to circumvent our security systems or that transmission of your information over the Internet will be intercepted. Accordingly, neither Health4TheWorld, nor its partners, nor any of their respective employees, officers or agents or the provider of the internet services on behalf of Health4TheWorld or the creator of the Website (nor any other person involving the management or establishment of the Website or otherwise involved in respect of the Website) can give any representation or warranty as to the absolute security of the data transmitted using the Website, and cannot give any guarantee that such data will not be compromised by bad actors.  It is your responsibility to protect the security of your login information. Please note that e-mails and other communications you send to us through our Website are not encrypted.  If you choose to provide data to or allow collection of data by Health4TheWorld or any of our partners or any of their respective officers, directors or employees or agents through use of the Website, then you do so understanding your own risks. If you choose to visit the Website, your visit and any dispute over privacy is subject to the Website Terms, including this Privacy Policy.");

        addHeaderWithText("Updating or Deleting Your Personal Information");
        addLineBreak();
        addTextViewWithText("You can access your Personal Information and confirm that it remains correct and up-to-date or choose whether or not you wish to receive material from us or some of our partners by logging into the Website and visiting your user account page. You may also contact us via contact@Health4TheWorld.org. We try to answer every email promptly, but may not always be able to do so. Keep in mind, however, that there will be residual information that will remain within our databases, access logs and other records, which may or may not contain your Personal Information.");
        addTextViewWithText("If you have any privacy-related questions, unresolved problems, or complaints you may contact us via contact@health4theworld.org");

        addHeaderWithText("California Privacy Rights");
        addLineBreak();
        addTextViewWithText("Under California’s \"Shine the Light\" law, California residents who provide personal information in obtaining products or services for personal, family or household use are entitled to request and obtain from us once a calendar year information about the customer information we shared, if any, with other businesses for their own direct marketing uses. If applicable, this information would include the categories of customer information and the names and addresses of those businesses with which we shared customer information for the immediately prior calendar year (e.g. requests made in 2012 will receive information regarding 2011 sharing activities).");
        addTextViewWithText("To obtain this information, please send an email message to contact@health4theworld.org with \"Request for California Privacy Information\" on the subject line and in the body of your message. We will provide the requested information to you at your e-mail address in response. Please be aware that not all information sharing is covered by the \"Shine the Light\" requirements and only information on covered sharing will be included in our response.");

        addHeaderWithText("International Privacy Practices");
        addLineBreak();
        addTextViewWithText("Health4TheWorld Websites are primarily operated and managed on servers located and operated within the United States. In order to provide our products and services to you, we may send and store your Personal Information (outside of the country where you reside or are located, including to the United States. Accordingly, if you reside or are located outside of the United States, your personal information may be transferred outside of the country where you reside or are located, including to countries that may not or do not provide the same level of protection for your personal information. We are committed to protecting the privacy and confidentiality of personal information when it is transferred. If you reside or are located within the European Economic Area and such transfers occur, we take appropriate steps to provide the same level of protection for the processing carried out in any such countries as you would have within the European Economic Area to the extent feasible under applicable law. By using and accessing our products and services, users who reside or are located in countries outside of the United States agree and consent to the transfer to and processing of personal information on servers located outside of the country where they reside, and that the protection of such information may be different than required under the laws of their residence or location.");

        addHeaderWithText("Changing Our Privacy Policy");
        addLineBreak();
        addTextViewWithText("Please note that we review our privacy practices from time to time, and that these practices are subject to change. We expressly reserve the right to modify the terms of this Privacy Policy at any time and in our reasonable discretion.   Any change, update, or modification will be effective immediately upon posting on our Website. We will notify you of any material change to this Privacy Policy by posting a notice on our Website’s homepage for a reasonable period of time following such update, and by changing the effective date (located at the bottom of this page). Be sure to return to this page periodically to ensure familiarity with the most current version of this Privacy Policy. Your continued use of the Website following our posting of a change notice will constitute binding acceptance of this Privacy Policy and all changes thereto.");

        addHeaderWithText("No Information from Children Under 13");
        addLineBreak();
        addTextViewWithText("Health4TheWorld strongly believes in protecting the privacy of children. In line with this belief, we do not knowingly collect or maintain Personal Information on our Website from persons under 13 years of age, and no part of our Website is directed to persons under 13 years of age. If you are under 13 years of age, then please do not use or access this Website at any time or in any manner. We will take appropriate steps to delete any Personal Information of persons less than 13 years of age that has been collected on our Website without verified parental consent upon learning of the existence of such Personal Information.");
    }

    public void setUpCopyright() {

    }
}

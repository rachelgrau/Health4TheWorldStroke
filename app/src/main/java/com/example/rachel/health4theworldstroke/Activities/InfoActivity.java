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

    public void addLineBreak() {
        LinearLayout ll = (LinearLayout) findViewById(R.id.text_linear_layout);
        View line = new View(this);
        line.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 3));
        line.setBackgroundColor(ContextCompat.getColor(this, R.color.darkGray));
        ll.addView(line);
    }

    public void setUpAboutUs() {

    }

    public void setUpTerms() {

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

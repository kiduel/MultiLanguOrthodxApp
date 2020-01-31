package com.example.kidus11.amhtiggeeeng;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

/**
 * Created by kidus11 on 12/19/17.
 */

public class Utility {
    public static final int GEEZ = 1;
    public final static int AMHARIC = 2;
    public final static int ENGLISH = 3;
    public final static int TIGRIGNA = 4;
    private static final String TAG = Utility.class.getName();

    /**
     * We are going be using this method to set the language
     * @param day - this will be the day which we are finding the prayer of
     * @param context - context used to get Resources
     * @return Language - we return the Language
     */
    public static int setLanguage(String day, Context context) {
        int Language = 0;
        if ( day.equals((context.getResources().getString(R.string.day_monday_geez)))
                || day.equals((context.getResources().getString(R.string.day_tuesday_geez)))
                || day.equals((context.getResources().getString(R.string.day_wednesday_geez)))
                || day.equals((context.getResources().getString(R.string.day_thursday_geez)))
                || day.equals((context.getResources().getString(R.string.day_saturday_geez)))
                || day.equals((context.getResources().getString(R.string.day_friday_geez)))
                || day.equals((context.getResources().getString(R.string.day_saturday_geez)))
                || day.equals((context.getResources().getString(R.string.day_sunday_geez)))
                || day.equals((context.getResources().getString(R.string.daw_geez_1st)))
                || day.equals((context.getResources().getString(R.string.daw_geez_2nd)))
                || day.equals((context.getResources().getString(R.string.daw_geez_3rd)))
                || day.equals((context.getResources().getString(R.string.daw_geez_4th)))
                || day.equals((context.getResources().getString(R.string.daw_geez_5th)))

                ) {
            Language = GEEZ;
        } else if ( (day.equals((context.getResources().getString(R.string.day_monday_amharic)))
                || day.equals((context.getResources().getString(R.string.day_tuesday_amharic)))
                || day.equals((context.getResources().getString(R.string.day_wednesday_amharic)))
                || day.equals((context.getResources().getString(R.string.day_thursday_amharic)))
                || day.equals((context.getResources().getString(R.string.day_saturday_amharic)))
                || day.equals((context.getResources().getString(R.string.day_friday_amharic)))
                || day.equals((context.getResources().getString(R.string.day_saturday_amharic)))
                || day.equals((context.getResources().getString(R.string.day_sunday_amharic)))
                || day.equals((context.getResources().getString(R.string.daw_amh_1st)))
                || day.equals((context.getResources().getString(R.string.daw_amh_2nd)))
                || day.equals((context.getResources().getString(R.string.daw_amh_3rd)))
                || day.equals((context.getResources().getString(R.string.daw_amh_4th)))
                || day.equals((context.getResources().getString(R.string.daw_amh_5th)))

        ) )

        {
            Language = AMHARIC;
        } else if ( (day.equals((context.getResources().getString(R.string.day_monday_english)))
                || day.equals((context.getResources().getString(R.string.day_tuesday_english)))
                || day.equals((context.getResources().getString(R.string.day_wednesday_english)))
                || day.equals((context.getResources().getString(R.string.day_thursday_english)))
                || day.equals((context.getResources().getString(R.string.day_saturday_english)))
                || day.equals((context.getResources().getString(R.string.day_friday_english)))
                || day.equals((context.getResources().getString(R.string.day_saturday_english)))
                || day.equals((context.getResources().getString(R.string.day_sunday_english)))
                || day.equals((context.getResources().getString(R.string.daw_eng_1st)))
                || day.equals((context.getResources().getString(R.string.daw_eng_2nd)))
                || day.equals((context.getResources().getString(R.string.daw_eng_3rd)))
                || day.equals((context.getResources().getString(R.string.daw_eng_4th)))
                || day.equals((context.getResources().getString(R.string.daw_eng_5th)))
                || day.equals((context.getResources().getString(R.string.daw_eng_6th)))
                || day.equals((context.getResources().getString(R.string.daw_eng_7th)))
                || day.equals((context.getResources().getString(R.string.daw_eng_8th)))
        ) ) {
            Language = ENGLISH;
        } else if ( (day.equals((context.getResources().getString(R.string.day_monday_tig)))
                || day.equals((context.getResources().getString(R.string.day_tuesday_tig)))
                || day.equals((context.getResources().getString(R.string.day_wednesday_tig)))
                || day.equals((context.getResources().getString(R.string.day_thursday_tig)))
                || day.equals((context.getResources().getString(R.string.day_saturday_tig)))
                || day.equals((context.getResources().getString(R.string.day_friday_tig)))
                || day.equals((context.getResources().getString(R.string.day_saturday_tig)))
                || day.equals((context.getResources().getString(R.string.day_sunday_tig)))
                || day.equals((context.getResources().getString(R.string.daw_tig_1st)))
                || day.equals((context.getResources().getString(R.string.daw_tig_2nd)))
                || day.equals((context.getResources().getString(R.string.daw_tig_3rd)))
                || day.equals((context.getResources().getString(R.string.daw_tig_4th)))
                || day.equals((context.getResources().getString(R.string.daw_tig_5th)))
                || day.equals((context.getResources().getString(R.string.daw_tig_6th)))
                || day.equals((context.getResources().getString(R.string.daw_tig_7th)))

        ) ) {
            Language = TIGRIGNA;
        } else {
            Log.e(TAG, "ERROR SETTING LANG");
        }
        return Language;
    }

    /**
     * We are going be using this method to set the diffrent prayers of the days (Elet)
     * @param language - this is the lanauge of the prayer
     * @param day - the day of the
     * @param context - context used to get Resources
     * @return prayer - we return the prayer
     */
    public static String PrayerWithLanaguage(int language, String day, Context context) {
        String prayer = "";

        if ( language == GEEZ ) {
            if ( day.equals((context.getResources().getString(R.string.day_monday_geez))) ) {
                prayer = ((context.getResources().getString(R.string.wdase_maryam_geez_mon)));
            } else if ( day.equals((context.getResources().getString(R.string.day_tuesday_geez))) ) {
                prayer = ((context.getResources().getString(R.string.wdase_maryam_geez_tues)));
            } else if ( day.equals((context.getResources().getString(R.string.day_wednesday_geez))) ) {
                prayer = ((context.getResources().getString(R.string.wdase_maryam_geez_wed)));
            } else if ( day.equals((context.getResources().getString(R.string.day_thursday_geez))) ) {
                prayer = ((context.getResources().getString(R.string.wdase_maryam_geez_thur)));
            } else if ( day.equals((context.getResources().getString(R.string.day_friday_geez))) ) {
                prayer = ((context.getResources().getString(R.string.wdase_maryam_geez_fri)));
            } else if ( day.equals((context.getResources().getString(R.string.day_saturday_geez))) ) {
                prayer = ((context.getResources().getString(R.string.wdase_maryam_geez_sat)));
            } else if ( day.equals((context.getResources().getString(R.string.day_sunday_geez))) ) {
                prayer = ((context.getResources().getString(R.string.wdase_maryam_geez_sun)));
            }
        } else if ( language == AMHARIC ) {
            if ( day.equals((context.getResources().getString(R.string.day_monday_amharic))) ) {
                prayer = ((context.getResources().getString(R.string.wdase_maryam_amh_mon)));
            } else if ( day.equals((context.getResources().getString(R.string.day_tuesday_amharic))) ) {
                prayer = ((context.getResources().getString(R.string.wdase_maryam_amh_tues)));
            } else if ( day.equals((context.getResources().getString(R.string.day_wednesday_amharic))) ) {
                prayer = ((context.getResources().getString(R.string.wdase_maryam_amh_wed)));
            } else if ( day.equals((context.getResources().getString(R.string.day_thursday_amharic))) ) {
                prayer = ((context.getResources().getString(R.string.wdase_maryam_amh_thur)));
            } else if ( day.equals((context.getResources().getString(R.string.day_friday_amharic))) ) {
                prayer = (context.getResources().getString(R.string.wdase_maryam_amh_fri));
            } else if ( day.equals(context.getResources().getString(R.string.day_saturday_amharic)) ) {
                prayer = ((context.getResources().getString(R.string.wdase_maryam_amh_sat)));
            } else if ( day.equals((context.getResources().getString(R.string.day_sunday_amharic))) ) {
                prayer = ((context.getResources().getString(R.string.wdase_maryam_amh_sun)));

            }
        } else if ( language == ENGLISH ) {
            if ( day.equals((context.getResources().getString(R.string.day_monday_english))) ) {
                prayer = ((context.getResources().getString(R.string.wdase_maryam_eng_mon)));
            } else if ( day.equals((context.getResources().getString(R.string.day_tuesday_english))) ) {
                prayer = ((context.getResources().getString(R.string.wdase_maryam_eng_tues)));
            } else if ( day.equals((context.getResources().getString(R.string.day_wednesday_english))) ) {
                prayer = ((context.getResources().getString(R.string.wdase_maryam_eng_wed)));
            } else if ( day.equals((context.getResources().getString(R.string.day_thursday_english))) ) {
                prayer = ((context.getResources().getString(R.string.wdase_maryam_eng_thur)));
            } else if ( day.equals((context.getResources().getString(R.string.day_friday_english))) ) {
                prayer = ((context.getResources().getString(R.string.wdase_maryam_eng_fri)));
            } else if ( day.equals((context.getResources().getString(R.string.day_saturday_english))) ) {
                prayer = ((context.getResources().getString(R.string.wdase_maryam_eng_sat)));
            } else if ( day.equals((context.getResources().getString(R.string.day_sunday_english))) ) {
                prayer = ((context.getResources().getString(R.string.wdase_maryam_eng_sun)));
            }

        } else if ( language == TIGRIGNA ) {
            if ( day.equals((context.getResources().getString(R.string.day_monday_tig))) ) {
                prayer = ((context.getResources().getString(R.string.wdase_maryam_tig_mon)));
            } else if ( day.equals((context.getResources().getString(R.string.day_tuesday_tig))) ) {
                prayer = ((context.getResources().getString(R.string.wdase_maryam_tig_tues)));
            } else if ( day.equals((context.getResources().getString(R.string.day_wednesday_tig))) ) {
                prayer = ((context.getResources().getString(R.string.wdase_maryam_tig_wed)));
            } else if ( day.equals((context.getResources().getString(R.string.day_thursday_tig))) ) {
                prayer = ((context.getResources().getString(R.string.wdase_maryam_tig_thur)));
            } else if ( day.equals((context.getResources().getString(R.string.day_friday_tig))) ) {
                prayer = ((context.getResources().getString(R.string.wdase_maryam_tig_fri)));
            } else if ( day.equals((context.getResources().getString(R.string.day_saturday_tig))) ) {
                prayer = ((context.getResources().getString(R.string.wdase_maryam_tig_sat)));
            } else if ( day.equals((context.getResources().getString(R.string.day_sunday_tig))) ) {
                prayer = ((context.getResources().getString(R.string.wdase_maryam_tig_sun)));
            }
        }
        return prayer;
    }


    /** We are going to use this method to refer to get the prayers of Mez Dawit, we will make this its own method prayer
     * @param language - this is the lanauge of the prayer
     * @param day - the day of the
     * @param context - context used to get Resources
     * @return  String[] dawit_prayer - we return all the three prayers of Mez dawit, and each prayer will be shown in the horizontal fragments
     */
    public static String[] forMezDawit(int language, String day, Context context) {
        String prayer_one = "";
        String prayer_two = "";
        String prayer_three = "";


        if ( language == GEEZ ) {
            if ( day.equals(context.getResources().getString(R.string.daw_geez_1st)) ) {
                prayer_one = ((context.getResources().getString(R.string.daw_geez_first_first)));
                prayer_two = ((context.getResources().getString(R.string.daw_geez_first_second)));
                prayer_three = ((context.getResources().getString(R.string.daw_geez_first_third)));
            } else if ( day.equals(context.getResources().getString(R.string.daw_geez_2nd)) ) {
                prayer_one = ((context.getResources().getString(R.string.daw_geez_second_first)));
                prayer_two = ((context.getResources().getString(R.string.daw_geez_second_second)));
                prayer_three = ((context.getResources().getString(R.string.daw_geez_second_third)));
            } else if ( day.equals(context.getResources().getString(R.string.daw_geez_3rd)) ) {
                prayer_one = ((context.getResources().getString(R.string.daw_geez_third_first)));
                prayer_two = ((context.getResources().getString(R.string.daw_geez_third_second)));
                prayer_three = ((context.getResources().getString(R.string.daw_geez_third_third)));
            } else if ( day.equals(context.getResources().getString(R.string.daw_geez_4th)) ) {
                prayer_one = ((context.getResources().getString(R.string.daw_geez_fourth_first)));
                prayer_two = ((context.getResources().getString(R.string.daw_geez_fourth_second)));
                prayer_three = ((context.getResources().getString(R.string.daw_geez_fourth_third)));
            } else if ( day.equals(context.getResources().getString(R.string.daw_geez_5th)) ) {
                prayer_one = ((context.getResources().getString(R.string.daw_geez_fifth_first)));
                prayer_two = ((context.getResources().getString(R.string.daw_geez_fifth_second)));
                prayer_three = ((context.getResources().getString(R.string.daw_geez_fifth_third)));
            }
        }

        if ( language == AMHARIC ) {
            if ( day.equals(context.getResources().getString(R.string.daw_amh_1st)) ) {
                prayer_one = ((context.getResources().getString(R.string.daw_amh_first_first)));
                prayer_two = ((context.getResources().getString(R.string.daw_amh_first_second)));
                prayer_three = ((context.getResources().getString(R.string.daw_amh_first_third)));
            } else if ( day.equals(context.getResources().getString(R.string.daw_amh_2nd)) ) {
                prayer_one = ((context.getResources().getString(R.string.daw_amh_second_first)));
                prayer_two = ((context.getResources().getString(R.string.daw_amh_second_second)));
                prayer_three = ((context.getResources().getString(R.string.daw_amh_second_third)));
            } else if ( day.equals(context.getResources().getString(R.string.daw_amh_3rd)) ) {
                prayer_one = ((context.getResources().getString(R.string.daw_amh_third_first)));
                prayer_two = ((context.getResources().getString(R.string.daw_amh_third_second)));
                prayer_three = ((context.getResources().getString(R.string.daw_amh_third_third)));
            } else if ( day.equals(context.getResources().getString(R.string.daw_amh_4th)) ) {
                prayer_one = ((context.getResources().getString(R.string.daw_amh_fourth_first)));
                prayer_two = ((context.getResources().getString(R.string.daw_amh_fourth_second)));
                prayer_three = ((context.getResources().getString(R.string.daw_amh_fourth_third)));
            } else if ( day.equals(context.getResources().getString(R.string.daw_amh_5th)) ) {
                prayer_one = ((context.getResources().getString(R.string.daw_amh_fifth_first)));
                prayer_two = ((context.getResources().getString(R.string.daw_amh_fifth_second)));
                prayer_three = ((context.getResources().getString(R.string.daw_amh_fifth_third)));
            }
        }

        if ( language == ENGLISH ) {


            if ( day.equals(context.getResources().getString(R.string.daw_eng_1st)) ) {
                prayer_one = (context.getResources().getString(R.string.daw_eng_into_prayer));
                prayer_two = ((context.getResources().getString(R.string.daw_eng_first_second)));
                prayer_three = ((context.getResources().getString(R.string.daw_eng_first_third)));
            } else if ( day.equals(context.getResources().getString(R.string.daw_eng_2nd)) ) {
                prayer_one = ((context.getResources().getString(R.string.daw_eng_into_prayer)));
                prayer_two = ((context.getResources().getString(R.string.daw_eng_second_second)));
                prayer_three = ((context.getResources().getString(R.string.daw_eng_second_third)));
            } else if ( day.equals(context.getResources().getString(R.string.daw_eng_3rd)) ) {
                prayer_one = ((context.getResources().getString(R.string.daw_eng_into_prayer)));
                prayer_two = ((context.getResources().getString(R.string.daw_eng_third_second)));
                prayer_three = ((context.getResources().getString(R.string.daw_eng_third_third)));
            } else if ( day.equals(context.getResources().getString(R.string.daw_eng_4th)) ) {
                prayer_one = ((context.getResources().getString(R.string.daw_eng_into_prayer)));
                prayer_two = ((context.getResources().getString(R.string.daw_eng_fourth_second)));
                prayer_three = ((context.getResources().getString(R.string.daw_eng_fourth_third)));
            }
            else if ( day.equals(context.getResources().getString(R.string.daw_eng_5th)) ) {
                prayer_one = ((context.getResources().getString(R.string.daw_eng_into_prayer)));
                prayer_two = ((context.getResources().getString(R.string.daw_eng_fifth_second)));
                prayer_three = ((context.getResources().getString(R.string.daw_eng_fifth_third)));
            }
            else if ( day.equals(context.getResources().getString(R.string.daw_eng_6th)) ) {
                prayer_one = ((context.getResources().getString(R.string.daw_eng_into_prayer)));
                prayer_two = ((context.getResources().getString(R.string.eng_six_prayer_second)));
                prayer_three = ((context.getResources().getString(R.string.eng_six_prayer_third)));
            }
            else if ( day.equals(context.getResources().getString(R.string.daw_eng_7th)) ) {
                prayer_one = ((context.getResources().getString(R.string.daw_eng_into_prayer)));
                prayer_two = ((context.getResources().getString(R.string.eng_seven_prayer_second)));
                prayer_three = ((context.getResources().getString(R.string.eng_seven_prayer_third)));
            }
            else if ( day.equals(context.getResources().getString(R.string.daw_eng_8th)) ) {
                prayer_one = ((context.getResources().getString(R.string.daw_eng_into_prayer)));
                prayer_two = ((context.getResources().getString(R.string.eng_eight_prayer_second)));
                prayer_three = ((context.getResources().getString(R.string.eng_seven_prayer_third)));
            }


        } else if ( language == TIGRIGNA ) {
            if ( day.equals(context.getResources().getString(R.string.daw_tig_1st)) ) {
                prayer_one = ((context.getResources().getString(R.string.daw_tig_intro)));
                prayer_two = ((context.getResources().getString(R.string.daw_tig_first_second)));
                prayer_three = ((context.getResources().getString(R.string.daw_tig_first_third)));
            } else if ( day.equals(context.getResources().getString(R.string.daw_tig_2nd)) ) {
                prayer_one = ((context.getResources().getString(R.string.daw_tig_intro)));
                prayer_two = ((context.getResources().getString(R.string.daw_tig_second_second)));
                prayer_three = ((context.getResources().getString(R.string.daw_tig_second_third)));
            } else if ( day.equals(context.getResources().getString(R.string.daw_tig_3rd)) ) {
                prayer_one = ((context.getResources().getString(R.string.daw_tig_intro)));
                prayer_two = ((context.getResources().getString(R.string.daw_tig_third_second)));
                prayer_three = ((context.getResources().getString(R.string.daw_tig_third_third)));
            } else if ( day.equals(context.getResources().getString(R.string.daw_tig_4th)) ) {
                prayer_one = ((context.getResources().getString(R.string.daw_tig_intro)));
                prayer_two = ((context.getResources().getString(R.string.daw_tig_fourth_second)));
                prayer_three = ((context.getResources().getString(R.string.daw_tig_fourth_third)));
            } else if (day.equals(context.getResources().getString(R.string.daw_tig_5th)) ) {
                prayer_one = ((context.getResources().getString(R.string.daw_tig_intro)));
                prayer_two = ((context.getResources().getString(R.string.daw_tig_fifth_second)));
                prayer_three = ((context.getResources().getString(R.string.daw_tig_fifth_third)));
            } else if (day.equals(context.getResources().getString(R.string.daw_tig_6th)) ) {
                prayer_one = ((context.getResources().getString(R.string.daw_tig_intro)));
                prayer_two = ((context.getResources().getString(R.string.daw_tig_six_second)));
                prayer_three = ((context.getResources().getString(R.string.daw_tig_six_third)));
            }
            else if (day.equals(context.getResources().getString(R.string.daw_tig_7th)) ) {
                prayer_one = ((context.getResources().getString(R.string.daw_tig_intro)));
                prayer_two = ((context.getResources().getString(R.string.daw_tig_seven_second)));
                prayer_three = ((context.getResources().getString(R.string.daw_tig_seven_third)));
            }
        }
        return new String[]{prayer_one, prayer_two, prayer_three};
    }

    public static boolean isOnline(Context context) {
        ConnectivityManager cm =
                (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        return netInfo != null && netInfo.isConnectedOrConnecting();
    }
}





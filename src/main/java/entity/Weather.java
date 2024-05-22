package entity;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static utility.Randomizer.setRandom;

public class Weather {
    private static final String CSV_FILE_PATH_BASE = "src/main/java/Resources/Weather/";
    private static String location;

    public Weather(String schoolName) {
        String[] locations;
        if (schoolName.contains("Forest") || schoolName.contains("Poplar") || schoolName.contains("Mountain") ||
                schoolName.contains("Summit") || schoolName.contains("Peak")) {
            locations = new String[]{"alaska", "spokane", "new_york"};
            location = locations[setRandom(0, 2)];
        } else if (schoolName.contains("Ocean") || schoolName.contains("Sea") || schoolName.contains("Bay") || schoolName.contains("Cape") ||
                schoolName.contains("Shore") || schoolName.contains("Sound") || schoolName.contains("Port")) {
            locations = new String[]{"alaska", "spokane", "los_angeles", "west_palm", "new_york"};
            location = locations[setRandom(0, 4)];
        } else if (schoolName.contains("Prairie") || schoolName.contains("Valley") || schoolName.contains("Grande") ||
                schoolName.contains("Grand") || schoolName.contains("Lake")) {
            locations = new String[]{"austin", "chicago"};
            location = locations[setRandom(0, 1)];
        } else if (schoolName.contains("Desert") || schoolName.contains("Canyon")) {
            locations = new String[]{"phoenix", "los_angeles"};
            location = locations[setRandom(0, 1)];
        } else {
            locations = new String[]{"alaska", "austin", "chicago", "los_angeles", "macon", "new_york", "phoenix", "spokane", "west_palm"};
            location = locations[setRandom(0, 8)];
        }
    }

    public static Map<String, String> parseCSV(Date date) {
        Map<String, String> weatherData = new HashMap<>();
        String csv_path = CSV_FILE_PATH_BASE + location + ".csv";
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        String targetDateStr = dateFormat.format(date);

        try (BufferedReader br = new BufferedReader(new FileReader(csv_path))) {
            String line = br.readLine();
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                if (values[1].equals(targetDateStr)) {
                    weatherData.put("PRCP", values[6]);
                    weatherData.put("SNOW", values[8]);
                    weatherData.put("SNWD", values[10]);
                    weatherData.put("TMAX", values[12]);
                    weatherData.put("TMIN", values[14]);
                    switch (location) {
                        case "alaska", "new_york" -> {
                            weatherData.put("ACMH", values[16]);
                            weatherData.put("ACSH", values[18]);
                            weatherData.put("AWND", values[28]);
                            weatherData.put("WDF1", values[62]);
                            weatherData.put("WSF1", values[76]);
                            weatherData.put("WT01", values[86]);
                            weatherData.put("WT02", values[88]);
                            weatherData.put("WT03", values[90]);
                            weatherData.put("WT04", values[92]);
                            weatherData.put("WT05", values[94]);
                            weatherData.put("WT06", values[96]);
                            weatherData.put("WT07", values[98]);
                            weatherData.put("WT08", values[100]);
                            weatherData.put("WT09", values[102]);
                            weatherData.put("WT11", values[104]);
                            weatherData.put("WT13", values[106]);
                            weatherData.put("WT14", values[108]);
                            weatherData.put("WT15", values[110]);
                            weatherData.put("WT16", values[112]);
                            weatherData.put("WT17", values[114]);
                            weatherData.put("WT18", values[116]);
                            weatherData.put("WT19", values[118]);
                            weatherData.put("WT21", values[120]);
                            weatherData.put("WT22", values[122]);
                        }
                        case "austin" -> {
                            weatherData.put("ACMH", values[16]);
                            weatherData.put("ACSH", values[18]);
                            weatherData.put("AWND", values[28]);
                            weatherData.put("WDF1", values[66]);
                            weatherData.put("WSF1", values[80]);
                            weatherData.put("WT01", values[94]);
                            weatherData.put("WT02", values[96]);
                            weatherData.put("WT03", values[98]);
                            weatherData.put("WT04", values[100]);
                            weatherData.put("WT05", values[102]);
                            weatherData.put("WT06", values[104]);
                            weatherData.put("WT07", values[106]);
                            weatherData.put("WT08", values[108]);
                            weatherData.put("WT09", values[110]);
                            weatherData.put("WT11", values[112]);
                            weatherData.put("WT13", values[114]);
                            weatherData.put("WT14", values[116]);
                            weatherData.put("WT15", values[118]);
                            weatherData.put("WT16", values[120]);
                            weatherData.put("WT17", values[122]);
                            weatherData.put("WT18", values[124]);
                            weatherData.put("WT19", values[126]);
                            weatherData.put("WT21", values[128]);
                            weatherData.put("WT22", values[130]);
                        }
                        case "chicago" -> {
                            weatherData.put("ACMH", values[16]);
                            weatherData.put("ACSH", values[18]);
                            weatherData.put("WT01", values[46]);
                            weatherData.put("WT02", values[48]);
                            weatherData.put("WT03", values[50]);
                            weatherData.put("WT04", values[52]);
                            weatherData.put("WT05", values[54]);
                            weatherData.put("WT06", values[56]);
                            weatherData.put("WT07", values[58]);
                            weatherData.put("WT08", values[60]);
                            weatherData.put("WT09", values[62]);
                            weatherData.put("WT11", values[64]);
                            weatherData.put("WT14", values[66]);
                            weatherData.put("WT16", values[68]);
                            weatherData.put("WT18", values[70]);
                        }
                        case "los_angeles" -> {
                            weatherData.put("ACMH", values[16]);
                            weatherData.put("ACSH", values[18]);
                            weatherData.put("AWND", values[28]);
                            //TODO: Check these later
                            weatherData.put("WDF1", values[54]);
                            weatherData.put("WSF1", values[60]);
                            weatherData.put("WT01", values[72]);
                            weatherData.put("WT02", values[74]);
                            weatherData.put("WT03", values[76]);
                            weatherData.put("WT04", values[78]);
                            weatherData.put("WT05", values[80]);
                            weatherData.put("WT06", values[82]);
                            weatherData.put("WT07", values[84]);
                            weatherData.put("WT08", values[86]);
                            weatherData.put("WT09", values[88]);
                            weatherData.put("WT11", values[90]);
                            weatherData.put("WT13", values[92]);
                            weatherData.put("WT14", values[94]);
                            weatherData.put("WT16", values[96]);
                            weatherData.put("WT18", values[98]);
                            weatherData.put("WT21", values[100]);
                        }
                        case "macon" -> {
                            weatherData.put("ACMH", values[18]);
                            weatherData.put("ACSH", values[22]);
                            weatherData.put("AWND", values[32]);
                            weatherData.put("WDF1", values[60]);
                            weatherData.put("WSF1", values[74]);
                            weatherData.put("WT01", values[86]);
                            weatherData.put("WT02", values[88]);
                            weatherData.put("WT03", values[90]);
                            weatherData.put("WT04", values[92]);
                            weatherData.put("WT05", values[94]);
                            weatherData.put("WT06", values[96]);
                            weatherData.put("WT07", values[98]);
                            weatherData.put("WT08", values[100]);
                            weatherData.put("WT09", values[102]);
                            weatherData.put("WT11", values[104]);
                            weatherData.put("WT13", values[106]);
                            weatherData.put("WT14", values[108]);
                            weatherData.put("WT15", values[110]);
                            weatherData.put("WT16", values[112]);
                            weatherData.put("WT17", values[114]);
                            weatherData.put("WT18", values[116]);
                            weatherData.put("WT19", values[118]);
                            weatherData.put("WT21", values[120]);
                            weatherData.put("WT22", values[122]);
                        }
                        case "phoenix" -> {
                            weatherData.put("ACMH", values[18]);
                            weatherData.put("ACSH", values[22]);
                            weatherData.put("AWND", values[32]);
                            weatherData.put("WDF1", values[56]);
                            weatherData.put("WSF1", values[70]);
                            weatherData.put("WT01", values[82]);
                            weatherData.put("WT02", values[84]);
                            weatherData.put("WT03", values[86]);
                            weatherData.put("WT04", values[88]);
                            weatherData.put("WT05", values[90]);
                            weatherData.put("WT06", values[92]);
                            weatherData.put("WT07", values[94]);
                            weatherData.put("WT08", values[96]);
                            weatherData.put("WT09", values[98]);
                            weatherData.put("WT11", values[100]);
                            weatherData.put("WT13", values[102]);
                            weatherData.put("WT14", values[104]);
                            weatherData.put("WT16", values[106]);
                            weatherData.put("WT18", values[108]);
                            weatherData.put("WT21", values[110]);
                            weatherData.put("WT22", values[112]);
                        }
                        case "spokane" -> {
                            weatherData.put("ACMH", values[16]);
                            weatherData.put("ACSH", values[18]);
                            weatherData.put("AWND", values[28]);
                            weatherData.put("WDF1", values[60]);
                            weatherData.put("WSF1", values[74]);
                            weatherData.put("WT01", values[84]);
                            weatherData.put("WT02", values[86]);
                            weatherData.put("WT03", values[88]);
                            weatherData.put("WT04", values[90]);
                            weatherData.put("WT05", values[92]);
                            weatherData.put("WT06", values[94]);
                            weatherData.put("WT07", values[96]);
                            weatherData.put("WT08", values[98]);
                            weatherData.put("WT09", values[100]);
                            weatherData.put("WT11", values[102]);
                            weatherData.put("WT13", values[104]);
                            weatherData.put("WT14", values[106]);
                            weatherData.put("WT16", values[108]);
                            weatherData.put("WT18", values[110]);
                            weatherData.put("WT21", values[112]);
                            weatherData.put("WT22", values[114]);
                        }
                        case "west_palm" -> {
                            weatherData.put("ACMH", values[16]);
                            weatherData.put("ACSH", values[18]);
                            weatherData.put("AWND", values[28]);
                            weatherData.put("WDF1", values[50]);
                            weatherData.put("WSF1", values[60]);
                            weatherData.put("WT01", values[68]);
                            weatherData.put("WT02", values[70]);
                            weatherData.put("WT03", values[72]);
                            weatherData.put("WT04", values[74]);
                            weatherData.put("WT05", values[76]);
                            weatherData.put("WT06", values[78]);
                            weatherData.put("WT07", values[80]);
                            weatherData.put("WT08", values[82]);
                            weatherData.put("WT09", values[84]);
                            weatherData.put("WT11", values[86]);
                            weatherData.put("WT13", values[88]);
                            weatherData.put("WT14", values[90]);
                            weatherData.put("WT16", values[92]);
                            weatherData.put("WT18", values[94]);
                            weatherData.put("WT21", values[96]);
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return weatherData;
    }

    public static WeatherPatterns determineWeatherPattern(Map<String, String> weatherData, String time) {

        if (weatherData == null || weatherData.isEmpty()) {
            return WeatherPatterns.NOT_AVAILABLE;
        }

        double prcp = Double.parseDouble(weatherData.getOrDefault("PRCP", "0"));
        double snow = Double.parseDouble(weatherData.getOrDefault("SNOW", "0"));
        double tmax = Double.parseDouble(weatherData.getOrDefault("TMAX", "-9999")) / 10.0;
        double tmin = Double.parseDouble(weatherData.getOrDefault("TMIN", "-9999")) / 10.0;
        double awnd = Double.parseDouble(weatherData.getOrDefault("AWND", "0"));
        int choice;
        // Day conditions
        if (time.equals("AM")) {
            choice = setRandom(0,100);
            // light rain and no snow
            if ( prcp < 25 && prcp > 0 && snow == 0 && tmin > 0) {
                // Wind
                if (awnd > 70) {
                    if (choice < 75) {
                        return WeatherPatterns.LIGHT_RAIN_AND_WIND;
                    } else if (choice < 85) {
                        return WeatherPatterns.DRIZZLE_AND_WIND;
                    } else {
                        return WeatherPatterns.RAIN_AND_WIND;
                    }
                // No wind
                } else {
                    if (choice < 25) {
                        return WeatherPatterns.SCATTERED_SHOWERS_DAY;
                    } else if (choice < 40) {
                        return WeatherPatterns.RAIN_AND_FOG;
                    } else if (choice < 80) {
                        return WeatherPatterns.FEW_SHOWERS_WORDED;
                    } else {
                        return WeatherPatterns.ISOLATED_SHOWERS_DAY;
                    }
                }
            // Moderate rain and no snow
            } else if (prcp <= 76 && snow == 0 && tmin > 0) {
                // Wind
                if (awnd > 70) {
                    if (choice < 75) {
                        return WeatherPatterns.RAIN_AND_WIND;
                    } else if (choice < 80) {
                        return WeatherPatterns.LIGHT_RAIN_AND_WIND;
                    } else {
                        return WeatherPatterns.HEAVY_RAIN_AND_WIND;
                    }
                // No wind
                } else {
                    if (choice < 50) {
                        return WeatherPatterns.RAIN;
                    } else if (choice < 60) {
                        return WeatherPatterns.RAIN_AND_FOG;
                    } else if (choice < 75) {
                        return WeatherPatterns.THUNDERSHOWERS;
                    } else if (choice < 80) {
                        return WeatherPatterns.ISOLATED_SHOWERS_DAY;
                    } else if (choice < 85) {
                        return WeatherPatterns.THUNDERSTORMS_WITH_HAZE;
                    } else {
                        return WeatherPatterns.SCATTERED_THUNDERSTORMS_DAY;
                    }
                }
            // Heavy rain and no snow
            } else if (prcp > 77 && snow == 0 && tmin > 0) {
                // Wind
                if (awnd > 70) {
                    if (choice < 50) {
                        return WeatherPatterns.STRONG_THUNDERSTORMS_AND_WIND;
                    } else {
                        return WeatherPatterns.THUNDERSTORMS_WITH_WIND;
                    }
                // No wind
                } else {
                    if (choice < 20) {
                        return WeatherPatterns.SCATTERED_THUNDERSTORMS_DAY;
                    } else if (choice < 40) {
                        return WeatherPatterns.SCATTERED_STRONG_THUNDERSTORMS_DAY;
                    } else if (choice < 60) {
                        return WeatherPatterns.AM_THUNDERSTORMS;
                    } else if (choice < 80) {
                        return WeatherPatterns.STRONG_THUNDERSTORMS;
                    } else {
                        return WeatherPatterns. THUNDERSTORMS;
                    }
                }
            }
            // Any mix of rain and snow
            else if (prcp > 0 && snow > 0 && tmin > -2) {
                // Wind
                if (awnd > 70) {
                    if (choice < 50) {
                        return WeatherPatterns.ICE_AND_WIND;
                    } else {
                        return WeatherPatterns.SLEET_AND_WIND;
                    }
                // No wind
                } else {
                    if (choice < 10) {
                        return WeatherPatterns.FREEZING_DRIZZLE;
                    } else if (choice < 20) {
                        return WeatherPatterns.FREEZING_RAIN;
                    } else if (choice < 30) {
                        return WeatherPatterns.FREEZING_RAIN_AND_SLEET;
                    } else if (choice < 40) {
                        return WeatherPatterns.FREEZING_RAIN_AND_THUNDER;
                    } else if (choice < 50) {
                        return WeatherPatterns.LIGHT_RAIN_AND_SNOW;
                    } else if (choice < 60) {
                        return WeatherPatterns.RAIN_AND_FREEZING_RAIN;
                    } else if (choice < 70) {
                        return WeatherPatterns.SLEET;
                    } else if (choice < 80) {
                        return WeatherPatterns.SLEET_WITH_THUNDER;
                    } else if (choice < 90) {
                        return WeatherPatterns.THUNDERSTORMS_WITH_SLEET;
                    } else if (choice < 95) {
                        return WeatherPatterns.WINTRY_MIX;
                    } else {
                        return  WeatherPatterns.WINTRY_MIX_WITH_THUNDER;
                    }
                }
            }
            // Any mix of rain and snow but low temps
            else if (prcp > 0 && snow > 0 && tmin < -2) {
                if (awnd > 70) {
                    return WeatherPatterns.RAIN_SNOW_AND_WIND;
                } else {
                    if (choice < 20) {
                        return WeatherPatterns.WINTRY_MIX;
                    } else if (choice < 40) {
                        return WeatherPatterns.WINTRY_MIX_WITH_THUNDER;
                    } else if (choice < 60) {
                        return WeatherPatterns.SLEET_AND_SNOW;
                    } else if (choice < 80) {
                        return WeatherPatterns.HEAVY_RAIN_AND_SNOW;
                    } else if (choice < 90) {
                        return WeatherPatterns.FREEZING_RAIN_AND_SNOW;
                    } else {
                        return WeatherPatterns.RAIN_AND_SNOW;
                    }
                }
            // Light amounts of snow but no rain
            } else if (prcp == 0 && snow > 0 && snow < 20) {
                // Wind
                if (awnd > 70) {
                    if (choice < 75) {
                        return WeatherPatterns.LIGHT_SNOW_AND_WIND;
                    } else {
                        return WeatherPatterns.SNOW_AND_WIND;
                    }
                // No wind
                } else {
                    if (choice < 25) {
                        return WeatherPatterns.SNOW;
                    } else if (choice < 50) {
                        return WeatherPatterns.LIGHT_SNOW;
                    } else if (choice < 75) {
                        return WeatherPatterns.SCATTERED_FLURRIES;
                    } else {
                        return WeatherPatterns.FLURRIES;
                    }
                }
            // Moderate to Heavy snow but no rain
            } else if (prcp == 0 && snow >= 20) {
                // Wind
                if (awnd > 70) {
                    if (choice < 25) {
                        return WeatherPatterns.HEAVY_SNOW_AND_WIND;
                    } else if (choice < 80) {
                        return WeatherPatterns.SNOW_AND_WIND;
                    } else {
                        return WeatherPatterns.BLIZZARD_BLOWING_SNOW;
                    }
                // No wind
                } else {
                    if (choice < 25) {
                        return WeatherPatterns.SNOW;
                    } else if (choice < 50) {
                        return WeatherPatterns.HEAVY_SNOW;
                    } else if (choice < 75) {
                        return WeatherPatterns.SNOW_WITH_THUNDER;
                    } else {
                        return WeatherPatterns.THUNDERSTORMS_WITH_SNOW;
                    }
                }
            // Fair conditions but no snow or rain
            } else if (prcp == 0 && snow == 0 && tmin > 0 && tmax < 30) {
                // Wind
                if (awnd > 70) {
                    if (choice < 20) {
                        return WeatherPatterns.FAIR_AND_WINDY;
                    } else if (choice < 40) {
                        return WeatherPatterns.PARTLY_CLOUDY_AND_WINDY_DAY;
                    } else if (choice < 60) {
                        return WeatherPatterns.SUNNY_AND_WINDY;
                    } else if (choice < 80) {
                        return WeatherPatterns.MOSTLY_SUNNY_AND_WINDY_DAY;
                    } else if (choice  < 90) {
                        return WeatherPatterns.MOSTLY_CLOUDY_AND_WINDY_DAY;
                    } else {
                        return WeatherPatterns.WINDY_CONDITIONS;
                    }
                // No wind
                } else {
                    if (choice < 10) {
                        return WeatherPatterns.AM_SUN_PM_CLOUDS;
                    } else if (choice < 20) {
                        return WeatherPatterns.AM_CLOUDS_PM_SUN_BOTTOM_2;
                    } else if (choice < 30) {
                        return WeatherPatterns.AM_CLOUDS_PM_SUN_BOTTOM;
                    } else if (choice < 40) {
                        return WeatherPatterns.CLOUD_1;
                    } else if (choice < 50) {
                        return WeatherPatterns.FAIR_DAY;
                    } else if (choice < 60) {
                        return WeatherPatterns.MOSTLY_SUNNY;
                    } else if (choice < 70) {
                        return WeatherPatterns.PARTLY_CLOUDY_DAY;
                    } else if (choice < 80) {
                        return WeatherPatterns.SUNNY;
                    } else if (choice < 90) {
                        return WeatherPatterns.VARIABLY_CLOUDY_DAY;
                    } else {
                        return WeatherPatterns.AM_FOG_PM_SUN;
                    }
                }
            // No snow or rain but really hot
            } else if (prcp == 0 && snow == 0 && tmax > 30) {
                // Wind
                if (awnd > 70) {
                    if (choice < 25) {
                        return WeatherPatterns.WINDY_CONDITIONS;
                    } else if (choice < 50) {
                        return WeatherPatterns.SUNNY_AND_WINDY;
                    } else if (choice < 75) {
                        return WeatherPatterns.FAIR_AND_WINDY;
                    } else {
                        return WeatherPatterns.CLOUDY_AND_WINDY_ALT;
                    }
                // No wind
                } else {
                    if (choice < 50) {
                        return WeatherPatterns.HOT_CONDITIONS;
                    } else if (choice < 60) {
                        return WeatherPatterns.SUNNY_AND_HAZY;
                    } else if (choice < 70) {
                        return WeatherPatterns.FAIR_AND_HAZY;
                    } else if (choice < 80) {
                        return WeatherPatterns.AM_CLOUDS_PM_SUN_TOP;
                    } else if (choice < 90) {
                        return WeatherPatterns.CLOUDY;
                    } else {
                        return WeatherPatterns.MOSTLY_SUNNY;
                    }
                }
            // If no snow or rain but freezing
            } else if (prcp == 0 && snow == 0 && tmin < -3) {
                if (choice < 25) {
                    return WeatherPatterns.FRIGID_CONDITIONS;
                } else if (choice < 50) {
                    return WeatherPatterns.ICY_CLOUD;
                } else if (choice < 75) {
                    return WeatherPatterns.DARK_CLOUD;
                } else {
                    return WeatherPatterns.PARTLY_CLOUDY_DAY;
                }
            } else {
                if (choice < 10) {
                    return WeatherPatterns.AM_FOG_PM_CLOUDS;
                } else if (choice < 20) {
                    return WeatherPatterns.DARK_CLOUD;
                } else if (choice < 30) {
                    return WeatherPatterns.ISOLATED_THUNDERSTORMS_DAY;
                } else if (choice < 40) {
                    return WeatherPatterns.MOSTLY_CLOUDY_DAY;
                } else if (choice < 50) {
                    return WeatherPatterns.MOSTLY_CLOUDY_AND_HAZY_DAY;
                } else if (choice < 60) {
                    return WeatherPatterns.THUNDER_IN_THE_VICINITY;
                } else if (choice < 70) {
                    return WeatherPatterns.THUNDER_CLOUD;
                } else if (choice < 80) {
                    return WeatherPatterns.MOSTLY_SUNNY;
                } else {
                    return WeatherPatterns.MOSTLY_SUNNY_AND_WINDY_DAY;
                }
            }
        // Night
        } else {
            if ( prcp < 25 && prcp > 0 && snow == 0) {
                if (awnd > 80) {
                    choice = setRandom(0,100);

                    if (choice < 25) {
                        return WeatherPatterns.PARTLY_CLOUDY_AND_WINDY_NIGHT;
                    } else if (choice < 50) {
                        return WeatherPatterns.SCATTERED_SHOWERS_NIGHT_ONLINE;
                    }

                }

            }
        }


        return WeatherPatterns.CLEAR;
    }
    public void determineWeatherAM(Date date) {
        Map<String, String> weatherData = parseCSV(date);
        WeatherPatterns pattern = determineWeatherPattern(weatherData, "AM");
        determineWeatherPM(date, pattern);
    }

    // Use day pattern to make some decisions on night
    // We could use some metrics from CSV here to make more accurate night predictions but want some chance thrown in
    public void determineWeatherPM(Date date, WeatherPatterns day) {
        Map<String, String> weatherData = parseCSV(date);
        WeatherPatterns pattern = determineWeatherPattern(weatherData, "PM");
    }


}

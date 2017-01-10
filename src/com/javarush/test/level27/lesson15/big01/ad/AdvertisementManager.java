package com.javarush.test.level27.lesson15.big01.ad;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Kira on 04.12.2016.
 */
public class AdvertisementManager {
    private final AdvertisementStorage storage = AdvertisementStorage.getInstance();
    private int timeSeconds;

    public AdvertisementManager(int timeSeconds) {
        this.timeSeconds = timeSeconds;
    }

    public void processVideos() {
        List<Advertisement> videos = storage.list();
        if (videos == null || videos.isEmpty())
            throw new NoVideoAvailableException();

        Collections.sort(videos, new Comparator<Advertisement>() {
            @Override
            public int compare(Advertisement o1, Advertisement o2) {
                if (o1.getAmountPerOneDisplaying() != o2.getAmountPerOneDisplaying())
                    return (int) (o2.getAmountPerOneDisplaying() - o1.getAmountPerOneDisplaying());
                else
                {
                    return ((int) (1000*o1.getAmountPerOneDisplaying() / o1.getDuration()) - (int) (1000*o2.getAmountPerOneDisplaying() / o2.getDuration()));
                }
            }
        });

        List<List<Advertisement>> powerVideos = powerSet(videos);
        List<List<Advertisement>> filteredPowerVideos = filterPowerVideos(powerVideos,timeSeconds);
        List<Advertisement> bestVideos = findBestVideos(filteredPowerVideos);

        for (Advertisement ad : bestVideos) {
            System.out.println(ad.getName() + " is displaying... " + ad.getAmountPerOneDisplaying() + ", " + (int) (1000*ad.getAmountPerOneDisplaying()/ad.getDuration()));
            ad.revalidate();
        }
    }

    private List<List<Advertisement>> powerSet(List<Advertisement> videos) {
         List<List<Advertisement>> powerList = new ArrayList<>();
         if (videos.isEmpty()) {
             powerList.add(new ArrayList<Advertisement>());
             return powerList;
         }
         Advertisement head = videos.get(0);
         List<Advertisement> rest = new ArrayList<Advertisement>(videos.subList(1,videos.size()));
         for (List<Advertisement> list : powerSet(rest)) {
             List<Advertisement> newList = new ArrayList<>();
             newList.add(head);
             newList.addAll(list);
             powerList.add(newList);
             powerList.add(list);
         }
         return powerList;
    }

    private List<List<Advertisement>> filterPowerVideos(List<List<Advertisement>> powerVideos, int timeSeconds) {
        List<List<Advertisement>> temporary = new ArrayList<>(powerVideos);
        for (List<Advertisement> list : powerVideos) {
            if (list.isEmpty()) {
                temporary.remove(list);
                continue;
            }
            for (Advertisement advertisement : list) {
                if (advertisement.getHits() <= 0) {
                    temporary.remove(list);
                    break;
                }

            }
        }
        List<List<Advertisement>> result = new ArrayList<>(temporary);
        for (List<Advertisement> list : temporary) {
            int sumTime = 0;
            for (Advertisement advertisement : list)
                sumTime+=advertisement.getDuration();
            if (sumTime > timeSeconds)
                result.remove(list);
        }
        return result;
    }

    private List<Advertisement> findBestVideos(List<List<Advertisement>> videos) {
        Collections.sort(videos, new Comparator<List<Advertisement>>() {
            @Override
            public int compare(List<Advertisement> o1, List<Advertisement> o2) {
            long money1 = 0;
            int duration1 = 0;
            int count1 = 0;
            for (Advertisement ad : o1) {
                money1 += ad.getAmountPerOneDisplaying();
                duration1 += ad.getDuration();
                count1++;
            }

            long money2 = 0;
            int duration2 = 0;
            int count2 = 0;
            for (Advertisement ad : o2) {
                money2 += ad.getAmountPerOneDisplaying();
                duration2 += ad.getDuration();
                count2++;
            }

            if (money1 != money2)
                return (int) (money2-money1);
            else if (duration1 != duration2)
                return duration2-duration1;
            else
                return count1-count2;
            }
        });
        return videos.get(0);
    }

}

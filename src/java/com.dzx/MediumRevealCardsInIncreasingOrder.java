package com.dzx;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 按递增顺序显示卡牌
 * 1. 从牌组顶部抽一张牌，显示它，然后将其从牌组中移出。
 * 2. 如果牌组中仍有牌，则将下一张处于牌组顶部的牌放在牌组的底部。
 * 3. 如果仍有未显示的牌，那么返回步骤 1。否则，停止行动。
 * 返回能以递增顺序显示卡牌的牌组顺序
 *
 * 取牌过程相当于将牌排序后围成圈，每隔一张取出一张牌，直到都取完
 */
public class MediumRevealCardsInIncreasingOrder {
    public int[] deckRevealedIncreasing(int[] deck) {
        Arrays.sort(deck);
        if (deck.length < 3) {
            return deck;
        }
        Queue<Integer> queue1 = new LinkedList<>();
        Queue<Integer> queue2 = new LinkedList<>();
        for (int i=0 ; i<deck.length; i++) {
            queue1.offer(i);
        }
        int[] index = new int[deck.length];
        int flag = 0;
        Queue<Integer> temp;
        while (flag < deck.length) {
            if (queue1.isEmpty()) {
                temp = queue1;
                queue1 = queue2;
                queue2 = temp;
            }
            index[flag] = queue1.poll();
            flag ++;
            if (flag >= deck.length) {
                break;
            }
            if (queue1.isEmpty()) {
                temp = queue1;
                queue1 = queue2;
                queue2 = temp;
            }
            queue2.offer(queue1.poll());
        }
        int[] result = new int[deck.length];
        for (int i=0; i<deck.length; i++) {
            result[index[i]] = deck[i];
        }
        return result;
    }
}

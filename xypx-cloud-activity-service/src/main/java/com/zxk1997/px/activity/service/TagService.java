package com.zxk1997.px.activity.service;

import com.zxk1997.px.common.enums.PXTagEnum;
import com.zxk1997.px.common.models.PxTag;

public interface TagService {
	int addTag(PxTag tag,PXTagEnum type);
	
	int editTag(PxTag tag,PXTagEnum type);
	
	int delTag(PxTag tag,PXTagEnum type);
}

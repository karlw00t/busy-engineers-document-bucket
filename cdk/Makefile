# Copyright 2019 Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: Apache-2.0

bootstrap: | install deploy state create_grants

install:
	npm ci

deploy:
	npx cdk deploy BusyEngineersDocumentBucketStack --require-approval never
	npx cdk deploy BusyEngineersFaytheCMKStack --require-approval never
	npx cdk deploy BusyEngineersWalterCMKStack --require-approval never

state:
	npx ts-node bin/cdk_state.ts

create_grants:
	npx ts-node bin/create_grants.ts
	
revoke_grants: revoke_walter_grant revoke_faythe_grant

revoke_walter_grant:
	npx ts-node bin/revoke_walter_grants.ts

revoke_faythe_grant:
	npx ts-node bin/revoke_faythe_grants.ts

data_purge:
	npx ts-node bin/data_purge.ts
